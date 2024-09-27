package Tutorial2.web_searching02;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class WebSearching {
    public static String generateFakeDataInFile() {
        String filename = "src/Tutorial2/web_searching02/data.in";

        // Define the content you want to write to data.in
        String[] lines = {
                "A AB AC AD AE",
                "A AB AE AF",
                "AC AE AG AH AI",
                "AJ AK AL AM AN",
                "AO AP AQ AR AS"
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File " + filename + " created successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        return filename;
    }
    public static void main(String[] args) {
        String inputFile = generateFakeDataInFile();
        String outputFile = "src/Tutorial2/web_searching02/result.out";

        Map<String, Integer> wordFrequencyMap = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");  // Split by spaces or any whitespace
                for (String word : words) {
                    wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(wordFrequencyMap.size() + "\n");
            int numberOfWords = wordFrequencyMap.size();
            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                double frequency = (double) Math.round(((float) entry.getValue() / numberOfWords) * 100) / 100;
                writer.write(entry.getKey() + " " + frequency + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to the output file: " + e.getMessage());
        }
    }
}
