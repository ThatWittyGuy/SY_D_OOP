import java.util.Scanner;

public class UniqueDigitCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        String num = sc.next();
        int[] freq = new int[10];
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            if (Character.isDigit(ch)) {
                freq[ch - '0']++;
            }
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] == 1) {
                count++;
            }
        }
        System.out.println("Number of unique digits: " + count);
    }
}
