package Tutorial2.formatted_pattern;

import java.util.Scanner;

public class FormattedPattern {
    public static void drawPatternA(int n) {
        System.out.println("Pattern A:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void drawPatternB(int n) {
        System.out.println("Pattern B:");
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void drawPatternC(int n) {
        System.out.println("Pattern C:");
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print("  ");  // Adjust spacing to match pattern
            }
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void drawPatternD(int n) {
        System.out.println("Pattern D:");
        for (int i = n; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                System.out.print("  ");  // Adjust spacing to match pattern
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length (n) of the pattern: ");
        int n = scanner.nextInt();

        drawPatternA(n);
        drawPatternB(n);
        drawPatternC(n);
        drawPatternD(n);
    }
}
