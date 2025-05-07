import java.util.ArrayList;

class Employee {
    int empId;
    String empName;
    String email;
    String gender;
    float salary;

    Employee(int empId, String empName, String email, String gender, float salary) {
        this.empId = empId;
        this.empName = empName;
        this.email = email;
        this.gender = gender;
        this.salary = salary;
    }

    void GetEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + empName);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Salary: " + salary);
    }
}

class EmployeeDB {
    ArrayList<Employee> list = new ArrayList<>();

    boolean addEmployee(Employee e) {
        return list.add(e);
    }

    boolean deleteEmployee(int empId) {
        for (Employee e : list) {
            if (e.empId == empId) {
                list.remove(e);
                return true;
            }
        }
        return false;
    }

    String showPaySlip(int empId) {
        for (Employee e : list) {
            if (e.empId == empId) {
                return "PaySlip for Employee ID " + empId + ": Salary = " + e.salary;
            }
        }
        return "Employee not found";
    }
}

public class EmployeeManagementApp {
    public static void main(String[] args) {
        EmployeeDB db = new EmployeeDB();

        Employee e1 = new Employee(101, "John", "john@mail.com", "Male", 50000);
        Employee e2 = new Employee(102, "Sara", "sara@mail.com", "Female", 60000);

        db.addEmployee(e1);
        db.addEmployee(e2);

        System.out.println("Employee Details:");
        e1.GetEmployeeDetails();
        e2.GetEmployeeDetails();

        System.out.println(db.showPaySlip(101));
        System.out.println(db.showPaySlip(103));

        db.deleteEmployee(101);
        System.out.println("After deletion:");
        System.out.println(db.showPaySlip(101));
    }
}
