import java.util.Scanner;

class NonEligibleException extends Exception {
    NonEligibleException(String message) {
        super(message);
    }
}

class Citizen {
    String name;
    int id;
    int age;
    String country;
    String sex;
    String maritalStatus;
    double annualIncome;
    String economyStatus;

    Citizen(String name, int id, int age, String country, String sex, String maritalStatus, double annualIncome, String economyStatus) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.country = country;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.annualIncome = annualIncome;
        this.economyStatus = economyStatus;
    }

    public String toString() {
        return "Citizen Details:\n" +
               "Name: " + name + "\n" +
               "ID: " + id + "\n" +
               "Age: " + age + "\n" +
               "Country: " + country + "\n" +
               "Sex: " + sex + "\n" +
               "Marital Status: " + maritalStatus + "\n" +
               "Annual Income: " + annualIncome + "\n" +
               "Economy Status: " + economyStatus;
    }
}

public class CitizenApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name:");
        String name = sc.nextLine();
        System.out.println("Enter ID:");
        int id = sc.nextInt();
        System.out.println("Enter Age:");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Country:");
        String country = sc.nextLine();
        System.out.println("Enter Sex:");
        String sex = sc.nextLine();
        System.out.println("Enter Marital Status:");
        String maritalStatus = sc.nextLine();
        System.out.println("Enter Annual Income:");
        double annualIncome = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter Economy Status:");
        String economyStatus = sc.nextLine();

        try {
            if (age < 18 && !country.equalsIgnoreCase("India")) {
                throw new NonEligibleException("Citizen is not eligible: Age is below 18 and country is not 'India'.");
            }
            Citizen citizen = new Citizen(name, id, age, country, sex, maritalStatus, annualIncome, economyStatus);
            System.out.println(citizen);
        } catch (NonEligibleException e) {
            System.out.println(e.getMessage());
        }
    }
}
