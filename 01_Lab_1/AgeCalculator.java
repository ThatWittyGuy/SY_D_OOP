import java.util.Scanner;

public class AgeCalculator {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter birth day: ");
        int birthDay = scanner.nextInt();
        
        System.out.print("Enter birth month: ");
        int birthMonth = scanner.nextInt();
        
        System.out.print("Enter birth year: ");
        int birthYear = scanner.nextInt();

        int currentDay = 14;
        int currentMonth = 1;
        int currentYear = 2025;

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalDays = 0;

        for (int year = birthYear + 1; year < currentYear; year++) {
            totalDays += 365;
            if (isLeapYear(year)) {
                totalDays++;
            }
        }

        for (int month = 1; month < currentMonth; month++) {
            totalDays += daysInMonth[month - 1];
            if (month == 2 && isLeapYear(currentYear)) {
                totalDays++;
            }
        }
        
        totalDays += currentDay;

        for (int month = birthMonth + 1; month <= 12; month++) {
            totalDays += daysInMonth[month - 1];
            if (month == 2 && isLeapYear(birthYear)) {
                totalDays++;
            }
        }

        totalDays += (daysInMonth[birthMonth - 1] - birthDay);

        System.out.println("Total days: " + totalDays);
        scanner.close();
    }
}
