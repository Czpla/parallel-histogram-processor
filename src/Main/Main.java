package Main;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import Controller.ProcessingImageThread;

public class Main {

    public static void main(String[] args) throws Exception {
        String currentDirectory = System.getProperty("user.dir");
        String targetDirectoryPath = currentDirectory + File.separator + "src" + File.separator + "Files" + File.separator + "bird";

        File directory = new File(targetDirectoryPath);
        File[] imageFiles = directory
                .listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png") ||
                        name.toLowerCase().endsWith(".jpeg") || name.toLowerCase().endsWith(".gif"));

        int numThreads = Runtime.getRuntime().availableProcessors();

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        long startTime = System.currentTimeMillis();

        for (File imageFile : imageFiles) {
            Runnable worker = new ProcessingImageThread(imageFile, startTime);
            executor.execute(worker);
        }

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Total processing time: " + totalTime + " ms");
    }
}