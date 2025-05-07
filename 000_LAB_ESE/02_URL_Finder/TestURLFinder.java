import java.util.Scanner;

// public class URLFinder {
//     // Private field for the URL
//     private String url;

//     // Constructor with one String parameter
//     public URLFinder(String url) {
//         this.url = url;
//     }

//     // Method to check if a URL is valid (basic check: starts with http:// or https://)
//     public boolean urlChecker(String inputUrl) {
//         if (inputUrl == null) return false;
//         return inputUrl.startsWith("http://") || inputUrl.startsWith("https://");
//     }

//     // Optional: Getter for url (not required, but useful)
//     public String getUrl() {
//         return url;
//     }
// }

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
