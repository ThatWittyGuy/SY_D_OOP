class Employees {
    String name;
    int id;
    double basicSalary;

    Employees(String name, int id, double basicSalary) {
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

class Manager extends Employees {
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

class Developer extends Employees {
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

public class Company {
    public static void main(String[] args) {
        Employees emp1 = new Manager("Alice", 101, 50000, 10000);
        Employees emp2 = new Developer("Bob", 102, 40000, 8000);

        System.out.println("--- Manager Details ---");
        emp1.displayDetails();
        System.out.println("Total Salary: " + emp1.calculateSalary());

        System.out.println("\n--- Developer Details ---");
        emp2.displayDetails();
        System.out.println("Total Salary: " + emp2.calculateSalary());
    }
}
