import java.util.Scanner;

public class TestURLFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a URL:");
        String userInput = sc.nextLine();

        // Create URLFinder object
        URLFinder finder = new URLFinder(userInput);

        // Check if the entered URL is valid
        boolean isValid = finder.urlChecker(userInput);

        if (isValid) {
            System.out.println("Valid URL!");
        } else {
            System.out.println("Invalid URL.");
        }
    }
}
