import java.util.Scanner;

abstract class Shape {
    abstract double calculateArea();
    abstract double calculatePerimeter();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Triangle extends Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    double calculatePerimeter() {
        return a + b + c;
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Circle:");
        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();
        Circle circle = new Circle(radius);
        System.out.println("Area of Circle: " + circle.calculateArea());
        System.out.println("Perimeter of Circle: " + circle.calculatePerimeter());

        System.out.println("\nTriangle:");
        System.out.print("Enter side a: ");
        double a = sc.nextDouble();
        System.out.print("Enter side b: ");
        double b = sc.nextDouble();
        System.out.print("Enter side c: ");
        double c = sc.nextDouble();
        Triangle triangle = new Triangle(a, b, c);
        System.out.println("Area of Triangle: " + triangle.calculateArea());
        System.out.println("Perimeter of Triangle: " + triangle.calculatePerimeter());
    }
}
