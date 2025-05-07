import java.util.Scanner;

class URLFinder {
    private String url;

    public URLFinder(String url) {
        this.url = url;
    }

    public boolean urlChecker(String inputUrl) {
        if (inputUrl == null) return false;
        String lowerUrl = inputUrl.toLowerCase();
        if (!(lowerUrl.startsWith("http://") || lowerUrl.startsWith("https://"))) return false;
        if (inputUrl.length() < 10) return false; // minimum length check
        if (inputUrl.contains(" ")) return false; // no spaces allowed
        if (!inputUrl.contains(".")) return false; // must contain dot for domain
        if (inputUrl.indexOf('.') < inputUrl.indexOf("://") + 3) return false; // dot must come after protocol
        
        return true;
    }
}

public class TestURLFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String input = sc.nextLine();
        URLFinder finder = new URLFinder(input);
        if (finder.urlChecker(input)) {
            System.out.println("Valid URL");
        } else {
            System.out.println("Invalid URL");
        }
        sc.close();
    }
}
