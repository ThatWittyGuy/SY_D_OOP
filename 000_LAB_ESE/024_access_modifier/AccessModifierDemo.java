class Person {
    private String name;
    public int age;
    protected String address;
    String phoneNumber;

    Person(String name, int age, String address, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }

    public void updatePhoneNumber(String newNumber) {
        phoneNumber = newNumber;
    }
}

class Employee extends Person {
    public String employeeId;

    Employee(String name, int age, String address, String phoneNumber, String employeeId) {
        super(name, age, address, phoneNumber);
        this.employeeId = employeeId;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Employee ID: " + employeeId);
    }
}

public class AccessModifierDemo {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 30, "Delhi", "9876543210", "E101");
        emp.displayDetails();
        System.out.println("Phone Number: " + emp.phoneNumber);
        emp.updatePhoneNumber("9123456789");
        System.out.println("Updated Phone Number: " + emp.phoneNumber);
        System.out.println("Age: " + emp.age);
        System.out.println("Address: " + emp.address);
        System.out.println("Employee ID: " + emp.employeeId);
    }
}
