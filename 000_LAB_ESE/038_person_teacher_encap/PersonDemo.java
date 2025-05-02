import java.util.Scanner;

abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public abstract void displayDetails();
}

class Student extends Person {
    private String rollNumber;
    private String course;

    public Student(String name, int age, String rollNumber, String course) {
        super(name, age);
        this.rollNumber = rollNumber;
        this.course = course;
    }

    // Getters and setters
    public String getRollNumber() { return rollNumber; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public void displayDetails() {
        System.out.println("Student Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
    }
}

class Teacher extends Person {
    private String employeeId;
    private String subject;

    public Teacher(String name, int age, String employeeId, String subject) {
        super(name, age);
        this.employeeId = employeeId;
        this.subject = subject;
    }

    // Getters and setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    @Override
    public void displayDetails() {
        System.out.println("Teacher Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Subject: " + subject);
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Student
        System.out.println("Enter Student details:");
        System.out.print("Name: ");
        String sName = sc.nextLine();
        System.out.print("Age: ");
        int sAge = sc.nextInt();
        sc.nextLine();
        System.out.print("Roll Number: ");
        String rollNumber = sc.nextLine();
        System.out.print("Course: ");
        String course = sc.nextLine();

        // Input for Teacher
        System.out.println("Enter Teacher details:");
        System.out.print("Name: ");
        String tName = sc.nextLine();
        System.out.print("Age: ");
        int tAge = sc.nextInt();
        sc.nextLine();
        System.out.print("Employee ID: ");
        String empId = sc.nextLine();
        System.out.print("Subject: ");
        String subject = sc.nextLine();

        // Array of Person references
        Person[] people = new Person[2];
        people[0] = new Student(sName, sAge, rollNumber, course);
        people[1] = new Teacher(tName, tAge, empId, subject);

        // Display details using polymorphism
        System.out.println("\nDisplaying details of all persons:");
        for (Person p : people) {
            p.displayDetails();
            System.out.println();
        }
    }
}
