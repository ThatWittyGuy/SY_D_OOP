import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Scenario a: Divide by zero exception
        try {
            System.out.print("Enter a numerator: ");
            int numerator = scanner.nextInt();
            System.out.print("Enter a denominator: ");
            int denominator = scanner.nextInt();
            int result = numerator / denominator;
        } catch (ArithmeticException e) {
            System.out.println("You shouldn’t divide a number by zero.\n");
        }

        // Scenario b: Array index out of bounds exception 
        try {
            System.out.print("Enter an array size: ");
            int size = scanner.nextInt();
            int[] arr = new int[size];
            System.out.print("Enter an index to access: ");
            int index = scanner.nextInt();
            arr[index] = 10;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("OOPs!!!Array Index out of bounds.\n");
        }

        // Scenario c: Null pointer exception 
        try {
            String str = null;
            System.out.println("Tyring to print length of null string");
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Null Pointer Exception arises!!");
        }
    }
}
