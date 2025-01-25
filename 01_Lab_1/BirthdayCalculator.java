import java.util.Scanner;

public class BirthdayCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter birth year: ");
        int birthYear = sc.nextInt();

        System.out.print("Enter birth month: ");
        int birthMonth = sc.nextInt();

        System.out.print("Enter birth day: ");
        int birthDay = sc.nextInt();
        
        int currentYear = 2025;
        int currentMonth = 1;
        int currentDay = 14;
        
        int totalDays = 0;
        
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        for (int year = birthYear; year < currentYear; year++) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                totalDays += 366;
            else
                totalDays += 365;
        }
        
        for (int month = birthMonth; month < currentMonth; month++) {
            totalDays += monthDays[month - 1];
        }
        
        totalDays += currentDay - birthDay;

        System.out.println("Total days: " + totalDays);
        
        sc.close();
    }
}
