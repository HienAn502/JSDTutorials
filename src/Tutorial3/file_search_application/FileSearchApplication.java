package Tutorial3.file_search_application;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class FileSearchRunnable implements Runnable {
    private File file;
    private String keyword;
    private ArrayList<Integer> results;

    public FileSearchRunnable(File file, String keyword) {
        this.file = file;
        this.keyword = keyword;
        this.results = new ArrayList<>();
    }

    public File getFile() {
        return file;
    }

    public String getResults() {
        StringBuilder resultString = new StringBuilder();
        for (Integer position : results) {
            resultString.append(position).append(", ");
        }
        return resultString.toString();
    }

    @Override
    public void run() {
        // TODO: read file and find keyword -> print out keyword and position and then save position to results
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                int index = line.indexOf(keyword);
                while (index >= 0) {
                    System.out.println("Found keyword '" + keyword + "' in file '" + file.getName() + "' at line " + lineNumber + ", position " + index);
                    results.add(index);
                    index = line.indexOf(keyword, index + 1);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
public class FileSearchApplication {
    public static void main(String[] args) {
        String directoryPath = "src/Tutorial3/file_search_application/files";
        String keyword = "thread";

        File folder = new File(directoryPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No files found in the directory.");
            return;
        }

        // TODO: Run thread and retrieve each thread result after all finished
        ExecutorService executorService = Executors.newFixedThreadPool(files.length);
        ArrayList<FileSearchRunnable> searchTasks = new ArrayList<>();

        for (File file : files) {
            FileSearchRunnable task = new FileSearchRunnable(file, keyword);
            searchTasks.add(task);
            executorService.submit(task);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (FileSearchRunnable task : searchTasks) {
            System.out.println("Results for file '" + task.getFile().getName() + "': " + task.getResults());
        }

    }
}
