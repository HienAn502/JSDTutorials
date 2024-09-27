package Tutorial2.word_occurence;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class WordOccurence {
    public static String generateFakeDataInFile() {
        String filename = "src/Tutorial2/activity3/data.in";

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
        String outputFile = "src/Tutorial2/activity3/result.out";

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
            for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
                writer.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to the output file: " + e.getMessage());
        }
    }
}
