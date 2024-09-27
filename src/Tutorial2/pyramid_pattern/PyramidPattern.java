package Tutorial2.pyramid_pattern;

import java.util.Scanner;

public class PyramidPattern {
    public static void drawPyramidPattern(int n) {
        System.out.println("Pyramid Pattern:");
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print("  ");
            }

            int num = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num *= 2;  // Multiply the number by 2 each time
            }

            num /= 2;
            for (int j = i - 1; j >= 1; j--) {
                num /= 2;
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height (n) of the pattern: ");
        int n = scanner.nextInt();

        drawPyramidPattern(n);
    }
}
