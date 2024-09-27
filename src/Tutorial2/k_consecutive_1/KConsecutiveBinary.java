package Tutorial2.k_consecutive_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KConsecutiveBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length (n) of the binary strings: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number (n) of the consecutive 1: ");
        int k = scanner.nextInt();

        List<String> consecutiveBinaries = generateConsecutiveBinaries(n, k);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Tutorial2/k_consecutive_1/result.out"))) {
            writer.write(String.valueOf(consecutiveBinaries.size()));
            writer.newLine();

            for (String consecutiveBinary : consecutiveBinaries) {
                writer.write(consecutiveBinary);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static List<String> generateConsecutiveBinaries(int n, int k) {
        List<String> consecutiveBinaries = new ArrayList<>();
        generateConsecutiveBinariesRecursive(n, 0, "", consecutiveBinaries, k);
        return consecutiveBinaries;
    }

    private static void generateConsecutiveBinariesRecursive(int n, int index, String current, List<String> consecutiveBinaries, int k) {
        if (index == n) {
            if (containsConsecutive(current, k)) {
                consecutiveBinaries.add(current);
            }
            return;
        }

        generateConsecutiveBinariesRecursive(n, index + 1, current + "0", consecutiveBinaries, k);
        generateConsecutiveBinariesRecursive(n, index + 1, current + "1", consecutiveBinaries, k);
    }

    private static boolean containsConsecutive(String binaryString, int k) {
        int count = 0;
        int sequenceLength = 0;

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                sequenceLength++;
                if (sequenceLength == k) {
                    count++;
                }
            } else {
                sequenceLength = 0;
            }

            if (sequenceLength > k) {
                return false;
            }
        }

        return count == 1;
    }
}
