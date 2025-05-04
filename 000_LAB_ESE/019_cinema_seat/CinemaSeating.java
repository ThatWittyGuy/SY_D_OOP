import java.util.Scanner;


public class CinemaSeating {
   private static int[][] seats;
   private static int rows;
   private static int cols;


   public static void initializeSeats(int r, int c) {
       rows = r;
       cols = c;
       seats = new int[rows][cols]; // All initialized to 0 by default
   }


   public static void displaySeats() {
       System.out.println("\nSeat Map (0 = Available, 1 = Booked):");
       for (int i = 0; i < rows; i++) {
           for (int j = 0; j < cols; j++) {
               System.out.print(seats[i][j] + " ");
           }
           System.out.println();
       }
   }


   public static boolean isSeatAvailable(int row, int col) {
       if (row < 0 || row >= rows || col < 0 || col >= cols) {
           System.out.println("Invalid seat position.");
           return false;
       }
       return seats[row][col] == 0;
   }


   public static void bookSeat(int row, int col) {
       if (isSeatAvailable(row, col)) {
           seats[row][col] = 1;
           System.out.println("Seat [" + row + "][" + col + "] booked successfully.");
       } else {
           System.out.println("Seat [" + row + "][" + col + "] is already booked or invalid.");
       }
   }


   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter number of rows: ");
       int r = scanner.nextInt();
       System.out.print("Enter number of columns: ");
       int c = scanner.nextInt();


       initializeSeats(r, c);


       boolean running = true;
       while (running) {
           System.out.println("\nCinema Booking Menu: ");
           System.out.println("1. Display Seat Map");
           System.out.println("2. Book a Seat");
           System.out.println("3. Exit");
           System.out.print("Choose an option: ");
           int choice = scanner.nextInt();


           switch (choice) {
               case 1:
                   displaySeats();
                   break;
               case 2:
                   System.out.print("Enter row number: ");
                   int row = scanner.nextInt();
                   System.out.print("Enter column number: ");
                   int col = scanner.nextInt();
                   bookSeat(row, col);
                   break;
               case 3:
                   running = false;
                   System.out.println("Exiting system. Thank you!");
                   break;
               default:
                   System.out.println("Invalid choice!");
           }
       }


       scanner.close();
   }
}
