import java.util.Scanner;

interface Shape {
    double calculateArea();
}

class Circle implements Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle implements Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }
}

class Triangle implements Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class ShapeAreaDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape[] shapes = new Shape[3];

        System.out.println("Enter radius of circle:");
        double radius = sc.nextDouble();
        shapes[0] = new Circle(radius);

        System.out.println("Enter length and width of rectangle:");
        double length = sc.nextDouble();
        double width = sc.nextDouble();
        shapes[1] = new Rectangle(length, width);

        System.out.println("Enter base and height of triangle:");
        double base = sc.nextDouble();
        double height = sc.nextDouble();
        shapes[2] = new Triangle(base, height);

        for (int i = 0; i < shapes.length; i++) {
            System.out.println("Area of shape " + (i+1) + ": " + shapes[i].calculateArea());
        }
    }
}