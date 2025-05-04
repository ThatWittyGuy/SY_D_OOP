import java.util.Scanner;

class Rectangle {
    int length;
    int breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    boolean compareArea(Rectangle r) {
        int area1 = this.length * this.breadth;
        int area2 = r.length * r.breadth;
        return area1 == area2;
    }
}

class MathOperations {
    static int square(int n) {
        return n * n;
    }

    int cube(int n) {
        return n * n * n;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length and breadth of first rectangle:");
        int l1 = sc.nextInt();
        int b1 = sc.nextInt();
        Rectangle rect1 = new Rectangle(l1, b1);

        System.out.println("Enter length and breadth of second rectangle:");
        int l2 = sc.nextInt();
        int b2 = sc.nextInt();
        Rectangle rect2 = new Rectangle(l2, b2);

        if (rect1.compareArea(rect2)) {
            System.out.println("Areas are equal");
        } else {
            System.out.println("Areas are not equal");
        }

        System.out.println("Enter a number to find its square and cube:");
        int num = sc.nextInt();
        System.out.println("Square: " + MathOperations.square(num));

        MathOperations mo = new MathOperations();
        System.out.println("Cube: " + mo.cube(num));
    }
}
