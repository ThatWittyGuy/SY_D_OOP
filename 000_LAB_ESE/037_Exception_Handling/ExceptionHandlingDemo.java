import java.io.*;
import java.util.*;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Instead of asking user for file path, use "sample.txt" in current directory
            System.out.println("Checking for file: sample.txt");
            String filePath = "sample.txt";
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            System.out.println("File contents:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the path and try again.");
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }

        try {
            System.out.print("Enter two integers for division: ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Result: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integers only.");
            sc.nextLine();
        }

        try {
            int[] arr = {1, 2, 3};
            System.out.print("Enter index to access array element (0-2): ");
            int index = sc.nextInt();
            System.out.println("Array element: " + arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index out of bounds. Please enter a valid index.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer index.");
            sc.nextLine();
        }

        try {
            String str = null;
            System.out.println("String Value: 'Null'");
            System.out.println("Length of string: " + str.length());
        } catch (NullPointerException e) {
            System.out.println("Null value encountered. String is null.");
        }

        sc.close();
    }
}
