// Triangle with space

import java.util.*;

public class pattern2 {
    public static void main(String args[])
    {   
        Scanner sc = new Scanner(System.in);
        int i, j,n;
        System.out.print("Enter no. of rows = ");
        n = sc.nextInt();

        for (i = 0; i < n; i++) {
            for (j = n - i; j > 1; j--) {
                System.out.print(" ");
            }

            for (j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        sc.close();
    }
}
}

// OUTPUT:
// Enter no. of rows = 5
//     *   
//    * *  
//   * * * 
//  * * * *  
// * * * * * 