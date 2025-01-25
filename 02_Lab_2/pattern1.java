// LEFT HALF PYRAMID

import java.util.*;

public class pattern1 {
    public static void main(String args[])
    {   
        Scanner sc = new Scanner(System.in);
        int i, j,n;
        System.out.print("Enter no. of rows = ");
        n = sc.nextInt();

        for (i = n; i >= 1; i--) {
            for (j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (j = 0; j <= n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

// OUTPUT:
// Enter no. of rows = 5
//     *
//    **
//   ***
//  ****
// *****