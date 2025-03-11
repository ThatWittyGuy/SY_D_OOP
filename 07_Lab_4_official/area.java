import java.util.*;

class Shape {
    void getInputs() {
    }

    void setArea() {
    }
}

class Triangle extends Shape {
    private double base, height;

    void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base of triangle: ");
        base = sc.nextDouble();
        System.out.print("Enter height of triangle: ");
        height = sc.nextDouble();
    }

    void setArea() {
        double area = 0.5 * base * height;
        System.out.println("Area of triangle: " + area);
    }
}

class Square extends Shape {
    private double side;

    void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side of square: ");
        side = sc.nextDouble();
    }

    void setArea() {
        double area = side * side;
        System.out.println("Area of square: " + area);
    }
}

class Circle extends Shape {
    private double radius;

    void getInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of circle: ");
        radius = sc.nextDouble();
    }

    void setArea() {
        double area = 3.14159 * radius * radius;
        System.out.printf("Area of circle: %.2f\n", area);
    }
    
}


public class area {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        Square square = new Square();
        Circle circle = new Circle();

        System.out.println("1. Triangle");
        System.out.println("2. Square");
        System.out.println("3. Circle");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                triangle.getInputs();
                triangle.setArea();
                break;
            case 2:
                square.getInputs();
                square.setArea();
                break;
            case 3:
                circle.getInputs();
                circle.setArea();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}
