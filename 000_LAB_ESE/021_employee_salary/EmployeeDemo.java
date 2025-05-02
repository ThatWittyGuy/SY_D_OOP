import java.util.Scanner;

class Employee {
    String name;
    int id;
    double basicSalary;

    Employee(String name, int id, double basicSalary) {
        this.name = name;
        this.id = id;
        this.basicSalary = basicSalary;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Basic Salary: " + basicSalary);
    }

    double calculateSalary() {
        return basicSalary;
    }
}

class Manager extends Employee {
    double bonus;

    Manager(String name, int id, double basicSalary, double bonus) {
        super(name, id, basicSalary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return basicSalary + bonus;
    }
}

class Developer extends Employee {
    double projectAllowance;

    Developer(String name, int id, double basicSalary, double projectAllowance) {
        super(name, id, basicSalary);
        this.projectAllowance = projectAllowance;
    }

    @Override
    double calculateSalary() {
        return basicSalary + projectAllowance;
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Manager details: Name, ID, Basic Salary, Bonus");
        String mName = sc.next();
        int mId = sc.nextInt();
        double mBasic = sc.nextDouble();
        double mBonus = sc.nextDouble();
        Employee manager = new Manager(mName, mId, mBasic, mBonus);

        System.out.println("Enter Developer details: Name, ID, Basic Salary, Project Allowance");
        String dName = sc.next();
        int dId = sc.nextInt();
        double dBasic = sc.nextDouble();
        double dAllowance = sc.nextDouble();
        Employee developer = new Developer(dName, dId, dBasic, dAllowance);

        System.out.println("Manager Details:");
        manager.displayDetails();
        System.out.println("Total Salary: " + manager.calculateSalary());

        System.out.println("Developer Details:");
        developer.displayDetails();
        System.out.println("Total Salary: " + developer.calculateSalary());
    }
}
