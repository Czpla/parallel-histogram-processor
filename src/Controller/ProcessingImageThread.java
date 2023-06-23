package Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Helpers.CalculateChannelHistogram;
import Helpers.ReadFile;
import Helpers.SaveFile;

public class ProcessingImageThread implements Runnable {
    private File imageFile;
    private long startTime;

    public ProcessingImageThread(File imageFile, long startTime) {
        this.imageFile = imageFile;
        this.startTime = startTime;
    }

    @Override
    public void run() {
        BufferedImage image = ReadFile.read(imageFile.getAbsolutePath());
        List<Map<String, Object>> histograms = new ArrayList<>();

        int[] redHistogram = CalculateChannelHistogram.calculate(image, 0);
        int[] greenHistogram = CalculateChannelHistogram.calculate(image, 1);
        int[] blueHistogram = CalculateChannelHistogram.calculate(image, 2);

        String[] colors = {"red", "green", "blue"};

        for (String color : colors) {
            Map<String, Object> histogram = new HashMap<>();
            histogram.put("color", color);
            switch (color) {
                case "red":
                    histogram.put("value", redHistogram);
                    break;
                case "green":
                    histogram.put("value", greenHistogram);
                    break;
                case "blue":
                    histogram.put("value", blueHistogram);
                    break;
            }
            histograms.add(histogram);
        }

        SaveFile.save(imageFile.getName(), histograms, image);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Processing finished for file: " + imageFile.getName() + " - Total time: " + totalTime + "ms");
    }
}