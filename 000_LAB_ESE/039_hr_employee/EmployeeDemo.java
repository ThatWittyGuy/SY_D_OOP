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

// SHAPE POLYMORPH

// import java.util.Scanner;

// class Shape {
//     public void draw() {
//         System.out.println("Drawing a shape.");
//     }
//     public void erase() {
//         System.out.println("Erasing a shape.");
//     }
// }

// class Circle extends Shape {
//     @Override
//     public void draw() {
//         System.out.println("Drawing a Circle.");
//     }
//     @Override
//     public void erase() {
//         System.out.println("Erasing a Circle.");
//     }
// }

// class Triangle extends Shape {
//     @Override
//     public void draw() {
//         System.out.println("Drawing a Triangle.");
//     }
//     @Override
//     public void erase() {
//         System.out.println("Erasing a Triangle.");
//     }
// }

// class Square extends Shape {
//     @Override
//     public void draw() {
//         System.out.println("Drawing a Square.");
//     }
//     @Override
//     public void erase() {
//         System.out.println("Erasing a Square.");
//     }
// }

// public class ShapeDemo {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Choose a shape to draw and erase (1. Circle 2. Triangle 3. Square):");
//         int choice = sc.nextInt();
//         Shape chosenShape;
//         switch (choice) {
//             case 1: chosenShape = new Circle(); break;
//             case 2: chosenShape = new Triangle(); break;
//             case 3: chosenShape = new Square(); break;
//             default: System.out.println("Invalid choice."); return;
//         }
//         chosenShape.draw();
//         chosenShape.erase();
//     }
// }
