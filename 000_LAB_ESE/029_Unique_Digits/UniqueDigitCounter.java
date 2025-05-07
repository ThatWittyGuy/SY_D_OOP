// import java.util.Scanner;

// public class UniqueDigitCount {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter a number:");
//         String num = sc.next();
//         int[] freq = new int[10];
//         for (int i = 0; i < num.length(); i++) {
//             char ch = num.charAt(i);
//             if (Character.isDigit(ch)) {
//                 freq[ch - '0']++;
//             }
//         }
//         int count = 0;
//         for (int i = 0; i < 10; i++) {
//             if (freq[i] == 1) {
//                 count++;
//             }
//         }
//         System.out.println("Number of unique digits: " + count);
//     }
// }

import java.util.Scanner;

public class UniqueDigitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 0;
        while (true) {
            System.out.print("Enter an integer number: ");
            String input = sc.nextLine();
            try {
                N = Integer.parseInt(input);
                break; // valid integer, exit loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        int[] cnt = new int[10];
        int temp = Math.abs(N); // handle negative numbers by taking absolute value

        if (temp == 0) {
            cnt[0] = 1; // handle zero explicitly
        } else {
            while (temp > 0) {
                int rem = temp % 10;
                cnt[rem]++;
                temp /= 10;
            }
        }

        int res = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1) {
                res++;
            }
        }

        System.out.println("Count of unique digits: " + res);
        sc.close();
    }
}
