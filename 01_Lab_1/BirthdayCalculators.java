import java.util.Scanner;

public class BirthdayCalculators 
{    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter birth year: ");
        int birthYear = sc.nextInt();

        System.out.print("Enter birth month: ");
        int birthMonth = sc.nextInt();

        System.out.print("Enter birth day: ");
        int birthDay = sc.nextInt();
        
        // Fixed current date
        int currentYear = 2025;
        int currentMonth = 1;
        int currentDay = 14;
        
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;
        int year = birthYear;
        for (year = birthYear; year < currentYear; year++) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                totalDays += 366;
            } else {
                totalDays += 365;
            }
        }
        
        for (int month = birthMonth; month < currentMonth; month++) {
            if (month == 2 && (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                totalDays += 29;
            } else {
                totalDays += monthDays[month - 1];
            }
        }
        
    
        totalDays += currentDay;
        
        System.out.println("Total days from birthday: " + totalDays);
        
        sc.close();
    }
    
}

    
