import java.util.*;

abstract class Staff {
    String name;
    double salary;

    Staff(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract void displayDetails();
    abstract double calculateBonus();
    abstract void promote();
}

class Professor extends Staff {
    String department;
    int publications;

    Professor(String name, double salary, String department, int publications) {
        super(name, salary);
        this.department = department;
        this.publications = publications;
    }

    void displayDetails() {
        System.out.println("Professor: " + name + ", Salary: " + salary + ", Dept: " + department + ", Publications: " + publications);
    }

    double calculateBonus() {
        return salary * 0.2 + publications * 500;
    }

    void promote() {
        System.out.println(name + " promoted to Senior Professor.");
        salary += 10000;
    }
}

class AdministrativeStaff extends Staff {
    String position;

    AdministrativeStaff(String name, double salary, String position) {
        super(name, salary);
        this.position = position;
    }

    void displayDetails() {
        System.out.println("Admin Staff: " + name + ", Salary: " + salary + ", Position: " + position);
    }

    double calculateBonus() {
        return salary * 0.1;
    }

    void promote() {
        System.out.println(name + " promoted to higher administrative position.");
        salary += 5000;
    }
}

class MaintenanceStaff extends Staff {
    int yearsOfService;

    MaintenanceStaff(String name, double salary, int yearsOfService) {
        super(name, salary);
        this.yearsOfService = yearsOfService;
    }

    void displayDetails() {
        System.out.println("Maintenance Staff: " + name + ", Salary: " + salary + ", Years of Service: " + yearsOfService);
    }

    double calculateBonus() {
        return yearsOfService * 1000;
    }

    void promote() {
        System.out.println(name + " promoted to Maintenance Supervisor.");
        salary += 3000;
    }
}

public class UniversityStaffManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Staff> staffList = new ArrayList<>();

        System.out.println("Enter number of staff:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter staff type (1-Professor, 2-Admin, 3-Maintenance):");
            int type = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter name:");
            String name = sc.nextLine();
            System.out.println("Enter salary:");
            double salary = sc.nextDouble();

            if (type == 1) {
                sc.nextLine();
                System.out.println("Enter department:");
                String dept = sc.nextLine();
                System.out.println("Enter number of publications:");
                int pubs = sc.nextInt();
                staffList.add(new Professor(name, salary, dept, pubs));
            } else if (type == 2) {
                sc.nextLine();
                System.out.println("Enter position:");
                String pos = sc.nextLine();
                staffList.add(new AdministrativeStaff(name, salary, pos));
            } else if (type == 3) {
                System.out.println("Enter years of service:");
                int yrs = sc.nextInt();
                staffList.add(new MaintenanceStaff(name, salary, yrs));
            }
        }

        System.out.println("\n--- Staff Details and Bonuses ---");
        for (Staff s : staffList) {
            s.displayDetails();
            System.out.println("Bonus: " + s.calculateBonus());
        }

        System.out.println("\n--- Promoting all staff ---");
        for (Staff s : staffList) {
            s.promote();
            s.displayDetails();
        }
    }
}
