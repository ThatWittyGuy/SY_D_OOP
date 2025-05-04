import java.util.Scanner;

public class GCDMethods {

    public static int gcdEuclidean(int a, int b) {
        if (b == 0)
            return a;
        return gcdEuclidean(b, a % b);
    }

    public static int gcdIterative(int a, int b) {
        int min = Math.min(a, b);
        int gcd = 1;
        for (int i = min; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers:");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("GCD (Euclidean): " + gcdEuclidean(a, b));
        System.out.println("GCD (Iterative): " + gcdIterative(a, b));
    }
}
