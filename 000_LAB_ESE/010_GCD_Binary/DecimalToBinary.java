import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal number:");
        int num = sc.nextInt();

        if (num == 0) {
            System.out.println("Binary: 0");
            return;
        }

        StringBuilder binary = new StringBuilder();
        int n = num;

        while (n > 0) {
            int rem = n % 2;
            binary.append(rem);
            n = n / 2;
        }

        binary.reverse();
        System.out.println("Binary: " + binary.toString());
    }
}

// import java.util.Scanner;

// public class DecimalToBinary {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter a decimal number:");
//         int num = sc.nextInt();

//         if (num == 0) {
//             System.out.println("Binary: 0");
//             return;
//         }

//         int[] binary = new int[32];
//         int i = 0;
//         int n = num;

//         while (n > 0) {
//             binary[i] = n % 2;
//             n = n / 2;
//             i++;
//         }

//         System.out.print("Binary: ");
//         for (int j = i - 1; j >= 0; j--) {
//             System.out.print(binary[j]);
//         }
//         System.out.println();
//     }
// }
