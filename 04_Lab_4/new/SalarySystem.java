class Employee {
    String empName, empID, position, teamName, managerName;
    int daysPresent;
    double basicSalary;

    Employee(String empName, String empID, String position, int daysPresent, String teamName, String managerName, double basicSalary) {
        this.empName = empName;
        this.empID = empID;
        this.position = position;
        this.daysPresent = daysPresent;
        this.teamName = teamName;
        this.managerName = managerName;
        this.basicSalary = basicSalary;
    }

    void printDetails() {
        System.out.println("Employee ID: " + empID);
        System.out.println("Name: " + empName);
        System.out.println("Position: " + position);
        System.out.println("Team: " + teamName);
        System.out.println("Manager: " + managerName);
        System.out.println("Days Present: " + daysPresent);
        System.out.println("Basic Salary: " + basicSalary);
    }

    double calculateSalary(double bonusPercentage) {
        double hra = basicSalary * 0.2;
        double da = basicSalary * 0.1;
        double ta = basicSalary * 0.05;
        double bonus = basicSalary * (bonusPercentage / 100);
        return basicSalary + hra + da + ta + bonus;
    }

    double calculateBonus(double bonusPercentage) {
        return basicSalary * (bonusPercentage / 100);
    }

    double calculateTax(double grossSalary) {
        if (grossSalary <= 250000) return 0;
        else if (grossSalary <= 500000) return grossSalary * 0.05;
        else if (grossSalary <= 750000) return grossSalary * 0.1;
        else if (grossSalary <= 1000000) return grossSalary * 0.15;
        else if (grossSalary <= 1250000) return grossSalary * 0.2;
        else if (grossSalary <= 1500000) return grossSalary * 0.25;
        else return grossSalary * 0.3;
    }
}

class Manager extends Employee {
    double teamBonus;

    Manager(String empName, String empID, String position, int daysPresent, String teamName, double basicSalary, double teamBonus) {
        super(empName, empID, position, daysPresent, teamName, empName, basicSalary);
        this.teamBonus = teamBonus;
    }
}

public class SalarySystem {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John Doe", "E123", "Developer", 22, "Tech", "Alice Smith", 500000);
        Manager mgr = new Manager("Alice Smith", "M001", "Manager", 22, "Tech", 800000, 10);

        double empBonusAmount = emp1.calculateBonus(mgr.teamBonus);
        double empGrossSalary = emp1.calculateSalary(mgr.teamBonus);
        double empTax = emp1.calculateTax(empGrossSalary);
        double empNetSalary = empGrossSalary - empTax;

        double mgrBonusAmount = mgr.calculateBonus(0);
        double mgrGrossSalary = mgr.calculateSalary(0);
        double mgrTax = mgr.calculateTax(mgrGrossSalary);
        double mgrNetSalary = mgrGrossSalary - mgrTax;

        System.out.println("\nEmployee Details:");
        emp1.printDetails();
        System.out.println("Bonus Amount: " + empBonusAmount);
        System.out.println("Gross Salary: " + empGrossSalary);
        System.out.println("Tax Deducted: " + empTax);
        System.out.println("Net Salary: " + empNetSalary);

        System.out.println("\nManager Details:");
        mgr.printDetails();
        System.out.println("Bonus Amount: " + mgrBonusAmount);
        System.out.println("Gross Salary: " + mgrGrossSalary);
        System.out.println("Tax Deducted: " + mgrTax);
        System.out.println("Net Salary: " + mgrNetSalary);
    }
}
