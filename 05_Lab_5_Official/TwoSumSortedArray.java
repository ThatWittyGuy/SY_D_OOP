import java.util.Arrays;
import java.util.Scanner;

public class TwoSumSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();
        
        System.out.println("Enter array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        int left = 0, right = n - 1;
        while(left < right) {
            int sum = arr[left] + arr[right];
            if(sum == target) {
                System.out.println("[" + arr[left] + "," + arr[right] + "]");
                return;
            }
            else if(sum < target) left++;
            else right--;
        }
        
        System.out.println("No solution found");
        sc.close();
    }
}
