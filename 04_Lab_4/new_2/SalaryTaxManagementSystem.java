class Employee {
    String empName;
    int empID;
    String position;
    int daysPresent;
    String teamName;
    String managerName;
    double basicSalary;

    public Employee(String empName, int empID, String position, int daysPresent, String teamName, String managerName, double basicSalary) {
        this.empName = empName;
        this.empID = empID;
        this.position = position;
        this.daysPresent = daysPresent;
        this.teamName = teamName;
        this.managerName = managerName;
        this.basicSalary = basicSalary;
    }

    public double calculateHRA() {
        return 0.2 * basicSalary; 
    }

    public double calculateDA() {
        return 0.1 * basicSalary; 
    }

    public double calculateTA() {
        return 0.05 * basicSalary; 
    }

    public double calculateBonus() {
        if (this.position.equals("Manager")) {
            return 0; 
        }
        return 0; 
    }

    public double calculateGrossSalary() {
        return basicSalary + calculateHRA() + calculateDA() + calculateTA() + calculateBonus();
    }

    public double calculateTax() {
        double grossSalary = calculateGrossSalary();
        if (grossSalary <= 700000) {
            return 0; 
        } else if (grossSalary <= 900000) {
            return 0.15 * (grossSalary - 700000); 
        } else if (grossSalary <= 1200000) {
            return 0.20 * (grossSalary - 900000) + 30000; 
        } else {
            return 0.30 * (grossSalary - 1200000) + 90000; 
        }
    }

    public double calculateNetSalary() {
        return calculateGrossSalary() - calculateTax();
    }
}


class Manager extends Employee {
    double bonusPercent;

    public Manager(String empName, int empID, String position, int daysPresent, String teamName, String managerName, double basicSalary, double bonusPercent) {
        super(empName, empID, position, daysPresent, teamName, managerName, basicSalary);
        this.bonusPercent = bonusPercent;
    }

    public void applyBonus(Employee employee) {
        if (!employee.position.equals("Manager")) {
            employee.basicSalary += (bonusPercent / 100) * employee.basicSalary;
        }
    }
}

public class SalaryTaxManagementSystem {
    public static void main(String[] args) {
        Manager manager = new Manager("John Doe", 101, "Manager", 22, "Development", "None", 1000000, 10);

        Employee employee = new Employee("Jane Smith", 102, "Developer", 20, "Development", "John Doe", 500000);

        manager.applyBonus(employee);

        System.out.println("Employee Name: " + employee.empName);
        System.out.println("Employee ID: " + employee.empID);
        System.out.println("Position: " + employee.position);
        System.out.println("Team: " + employee.teamName);
        System.out.println("Manager: " + employee.managerName);
        System.out.println("Basic Salary: " + employee.basicSalary);
        System.out.println("Gross Salary: " + employee.calculateGrossSalary());
        System.out.println("Tax: " + employee.calculateTax());
        System.out.println("Net Salary: " + employee.calculateNetSalary());

        System.out.println("\nManager Name: " + manager.empName);
        System.out.println("Manager ID: " + manager.empID);
        System.out.println("Position: " + manager.position);
        System.out.println("Team: " + manager.teamName);
        System.out.println("Manager: " + manager.managerName);
        System.out.println("Basic Salary: " + manager.basicSalary);
        System.out.println("Gross Salary: " + manager.calculateGrossSalary());
        System.out.println("Tax: " + manager.calculateTax());
        System.out.println("Net Salary: " + manager.calculateNetSalary());
    }
}