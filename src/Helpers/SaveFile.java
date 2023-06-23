package Helpers;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SaveFile {

    public static void save(String fileName, List<Map<String, Object>> histograms, BufferedImage image) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt", true))) {
            writer.write("File: " + fileName);
            writer.newLine();

            for (Map<String, Object> histogram : histograms) {
                String color = (String) histogram.get("color");
                int[] values = (int[]) histogram.get("value");

                writer.write("Histogram " + color + ":");
                writer.newLine();

                for (int i = 0; i < 256; i++) {
                    if (values[i] != 0) {
                        double intensity = (double) values[i] / (double) (image.getWidth() * image.getHeight()) * 100.0;
                        writer.write("Value " + i + ": " + String.format("%.2f", intensity));
                        writer.newLine();
                    }
                }

                writer.newLine();
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}