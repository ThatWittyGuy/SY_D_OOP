import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private double price;

    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
        System.out.println("Default Constructor:");
        printDetails();
    }

    // Constructor with title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0.0;
        System.out.println("Constructor with Title and Author:");
        printDetails();
    }

    // Constructor with title, author, and price
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        System.out.println("Constructor with Title, Author, and Price:");
        printDetails();
    }

    public void printDetails() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Price : " + price);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Default constructor
        Book book1 = new Book();

        // Constructor with title and author
        System.out.println("Enter title for Book 2:");
        String title2 = sc.nextLine();
        System.out.println("Enter author for Book 2:");
        String author2 = sc.nextLine();
        Book book2 = new Book(title2, author2);

        // Constructor with title, author, and price
        System.out.println("Enter title for Book 3:");
        String title3 = sc.nextLine();
        System.out.println("Enter author for Book 3:");
        String author3 = sc.nextLine();
        System.out.println("Enter price for Book 3:");
        double price3 = sc.nextDouble();
        Book book3 = new Book(title3, author3, price3);
    }
}
