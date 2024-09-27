package Tutorial2.palindrome;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromicBinaryString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length (n) of the binary strings: ");
        int n = scanner.nextInt();

        List<String> palindromes = generatePalindromes(n);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Tutorial2/palindrome/result.out"))) {
            writer.write(String.valueOf(palindromes.size()));
            writer.newLine();

            for (String palindrome : palindromes) {
                writer.write(palindrome);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    private static List<String> generatePalindromes(int n) {
        List<String> palindromes = new ArrayList<>();
        generatePalindromesRecursive(n, 0, "", palindromes);
        return palindromes;
    }

    private static void generatePalindromesRecursive(int n, int index, String current, List<String> palindromes) {
        if (index == n) {
            if (isPalindrome(current)) {
                palindromes.add(current);
            }
            return;
        }

        generatePalindromesRecursive(n, index + 1, current + "0", palindromes);
        generatePalindromesRecursive(n, index + 1, current + "1", palindromes);
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
