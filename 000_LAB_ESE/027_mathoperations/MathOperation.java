import java.util.Scanner;

public class MathOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        int sum = 0;
        try {
            System.out.println("Enter 5 integers:");
            for (int i = 0; i < 5; i++) {
                String input = sc.next();
                numbers[i] = Integer.parseInt(input);
                sum += numbers[i];
            }
            double average = sum / 5.0;
            System.out.println("Sum: " + sum);
            System.out.println("Average: " + average);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input: Please enter only integers.");
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error occurred.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
        }
    }
}
