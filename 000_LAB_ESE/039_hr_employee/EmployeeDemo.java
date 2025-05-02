import java.util.Scanner;

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println(name + " is working.");
    }

    public double getSalary() {
        return 30000.0; // Example base salary
    }

    public String getName() {
        return name;
    }
}

class HRManager extends Employee {
    public HRManager(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println(getName() + " (HR Manager) is managing HR tasks.");
    }

    public void addEmployee(String newEmpName) {
        System.out.println("HR Manager added a new employee: " + newEmpName);
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Employee
        System.out.print("Enter Employee name: ");
        String empName = sc.nextLine();
        Employee emp = new Employee(empName);
        emp.work();
        System.out.println(emp.getName() + "'s Salary: " + emp.getSalary());

        // HR Manager
        System.out.print("\nEnter HR Manager name: ");
        String hrName = sc.nextLine();
        HRManager hr = new HRManager(hrName);
        hr.work();
        System.out.println(hr.getName() + "'s Salary: " + hr.getSalary());

        // Add new employee via HR
        System.out.print("Enter name of new employee to add: ");
        String newEmp = sc.nextLine();
        hr.addEmployee(newEmp);
    }
}
