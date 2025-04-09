import java.util.Scanner;

public class ExceptionHandlingExamples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option (1-5):");
        System.out.println("1. ArrayIndexOutOfBoundsException");
        System.out.println("2. ArithmeticException (Divide by Zero)");
        System.out.println("3. NumberFormatException");
        System.out.println("4. NullPointerException");
        System.out.println("5. StringIndexOutOfBoundsException");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                try {
                    System.out.println("Enter the size of the array (max 5):");
                    int size = scanner.nextInt();
                    int[] arr = new int[5];
                    System.out.println(arr[size]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Array index is out of bounds.");
                }
                break;
            case 2:
                try {
                    System.out.println("Enter a number to divide by 0:");
                    int num = scanner.nextInt();
                    int result = num/0;
                    System.out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    System.out.println("Division by zero is not allowed.");
                }
                break;
            case 3:
                try {
                    System.out.println("Enter a string to convert to an integer:");
                    String input = scanner.next();
                    int num = Integer.parseInt(input);
                    System.out.println("Converted number: " + num);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format.");
                }
                break;
            case 4:
                try {
                    String str = null;
                    System.out.println(str.length());
                } catch (NullPointerException e) {
                    System.out.println("Null pointer exception occurred.");
                }
                break;
            case 5:
                try {
                    System.out.println("Enter an index to access in 'Hello World':");
                    int index = scanner.nextInt();
                    String str = "Hello World";
                    char charAtIndex = str.charAt(index);
                    System.out.println("Character at index " + index + ": " + charAtIndex);
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("String index is out of bounds.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
        scanner.close();
    }
}
