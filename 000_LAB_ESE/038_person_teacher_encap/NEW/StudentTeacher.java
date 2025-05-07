abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public abstract void displayDetails();
}

class Student extends Person {
    private int rollNumber;
    private String course;

    public Student(String name, int age, int rollNumber, String course){
        super(name, age);
        this.rollNumber = rollNumber;
        this.course = course;
    }

    public int getRollNumber(){
        return rollNumber;
    }

    public void setRollNumber(int rollNumber){
        this.rollNumber = rollNumber;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }

    @Override
    public void displayDetails(){
        System.out.println("Student Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Course: " + course);
        System.out.println();
    }
}

class Teacher extends Person {
    private int employeeId;
    private String subject;

    public Teacher(String name, int age, int employeeId, String subject){
        super(name, age);
        this.employeeId = employeeId;
        this.subject = subject;
    }

    public int getEmployeeId(){
        return employeeId;
    }

    public void setEmployeeId(int employeeId){
        this.employeeId = employeeId;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    @Override
    public void displayDetails(){
        System.out.println("Teacher Details:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Subject: " + subject);
        System.out.println();
    }
}

public class StudentTeacher {
    public static void main(String[] args) {
        // Polymorphism: using Person references
        Person[] people = new Person[2];

        people[0] = new Student("Alice", 20, 101, "Computer Science");
        people[1] = new Teacher("Dr. Bob", 45, 5001, "Mathematics");

        for (int i = 0; i < people.length; i++) {
            people[i].displayDetails(); // Dynamic method dispatch
        }
    }
}
