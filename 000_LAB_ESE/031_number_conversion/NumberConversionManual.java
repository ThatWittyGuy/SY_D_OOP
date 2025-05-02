import java.util.Scanner;

public class NumberConversionManual {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer number:");
        int num = sc.nextInt();
        System.out.println("Given Number : " + num);
        System.out.print("Binary equivalent : ");
        printBinary(num);
        System.out.print("Octal equivalent : ");
        printOctal(num);
        System.out.print("Hexadecimal equivalent : ");
        printHex(num);
    }

    static void printBinary(int num) {
        if (num == 0) {
            System.out.println("0");
            return;
        }
        String res = "";
        int n = num;
        while (n > 0) {
            res = (n % 2) + res;
            n /= 2;
        }
        System.out.println(res);
    }

    static void printOctal(int num) {
        if (num == 0) {
            System.out.println("0");
            return;
        }
        String res = "";
        int n = num;
        while (n > 0) {
            res = (n % 8) + res;
            n /= 8;
        }
        System.out.println(res);
    }

    static void printHex(int num) {
        if (num == 0) {
            System.out.println("0");
            return;
        }
        String res = "";
        int n = num;
        char[] hexChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while (n > 0) {
            res = hexChars[n % 16] + res;
            n /= 16;
        }
        System.out.println(res);
    }
}
