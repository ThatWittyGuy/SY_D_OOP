import java.util.Scanner;

public class TrianglePatterns {
    // Print Pascal's Triangle
    public static void printPascalsTriangle(int rows) {
        for (int i = 0; i < rows; i++) {
            // Print spaces for alignment
            for (int s = 0; s < rows - i - 1; s++)
                System.out.print(" ");
            int num = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    // Print Number Triangle
    public static void printNumberTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            // Print leading spaces for alignment
            for (int s = 0; s < rows - i; s++)
                System.out.print(" ");
            // Print the row number, i times
            for (int j = 1; j <= i; j++)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows:");
        int rows = sc.nextInt();

        System.out.println("\nPascal's Triangle:");
        printPascalsTriangle(rows);

        System.out.println("\nNumber Triangle:");
        printNumberTriangle(rows);
    }
}
