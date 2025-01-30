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
    
    double calculateSalary() {
        double hra = 0.2 * basicSalary;
        double da = 0.1 * basicSalary;
        double ta = 0.05 * basicSalary;
        return basicSalary + hra + da + ta;
    }
    
    double calculateTax(double grossSalary) {
        if (grossSalary <= 250000) return 0;
        else if (grossSalary <= 500000) return 0.05 * (grossSalary - 250000);
        else if (grossSalary <= 750000) return 12500 + 0.1 * (grossSalary - 500000);
        else if (grossSalary <= 1000000) return 37500 + 0.15 * (grossSalary - 750000);
        else if (grossSalary <= 1250000) return 75000 + 0.2 * (grossSalary - 1000000);
        else if (grossSalary <= 1500000) return 125000 + 0.25 * (grossSalary - 1250000);
        else return 187500 + 0.3 * (grossSalary - 1500000);
    }
    
    void printEmployeeDetails() {
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee ID: " + empID);
        System.out.println("Position: " + position);
        System.out.println("Team Name: " + teamName);
        System.out.println("Manager Name: " + managerName);
        System.out.println("Basic Salary: " + basicSalary);
    }
}

class Manager extends Employee {
    double bonusPercentage;
    
    Manager(String empName, String empID, String position, int daysPresent, String teamName, String managerName, double basicSalary, double bonusPercentage) {
        super(empName, empID, position, daysPresent, teamName, managerName, basicSalary);
        this.bonusPercentage = bonusPercentage;
    }
    
    double calculateGrossSalaryWithBonus() {
        return calculateSalary() + (bonusPercentage / 100) * basicSalary;
    }
    
    double calculateSalaryWithBonus() {
        double grossSalary = calculateGrossSalaryWithBonus();
        return grossSalary - calculateTax(grossSalary);
    }
}

public class SalaryManagementSystem {
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", "E123", "Developer", 22, "Tech", "Alice", 500000);
        Manager mgr = new Manager("Alice", "M456", "Team Lead", 22, "Tech", "Alice", 700000, 10);
        
        emp.printEmployeeDetails();
        double empSalary = emp.calculateSalary();
        double empTax = emp.calculateTax(empSalary);
        System.out.println("Employee Gross Salary: " + empSalary);
        System.out.println("Employee Tax: " + empTax);
        System.out.println("Employee Salary (After Tax): " + (empSalary - empTax));
        System.out.println("");
        
        mgr.printEmployeeDetails();
        double mgrGrossSalary = mgr.calculateGrossSalaryWithBonus();
        double mgrSalary = mgr.calculateSalaryWithBonus();
        System.out.println("Manager Gross Salary (Before Tax): " + mgrGrossSalary);
        System.out.println("Manager Salary (After Bonus & Tax): " + mgrSalary);
    }
}
