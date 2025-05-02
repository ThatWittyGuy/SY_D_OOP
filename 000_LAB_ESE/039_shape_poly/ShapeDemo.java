import java.util.Scanner;

class Shape {
    public void draw() {
        System.out.println("Drawing a shape.");
    }
    public void erase() {
        System.out.println("Erasing a shape.");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
    @Override
    public void erase() {
        System.out.println("Erasing a Circle.");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle.");
    }
    @Override
    public void erase() {
        System.out.println("Erasing a Triangle.");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square.");
    }
    @Override
    public void erase() {
        System.out.println("Erasing a Square.");
    }
}

public class ShapeDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a shape to draw and erase (1. Circle 2. Triangle 3. Square):");
        int choice = sc.nextInt();
        Shape chosenShape;
        switch (choice) {
            case 1: chosenShape = new Circle(); break;
            case 2: chosenShape = new Triangle(); break;
            case 3: chosenShape = new Square(); break;
            default: System.out.println("Invalid choice."); return;
        }
        chosenShape.draw();
        chosenShape.erase();
    }
}
