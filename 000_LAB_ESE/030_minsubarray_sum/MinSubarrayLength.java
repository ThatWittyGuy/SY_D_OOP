import java.util.Scanner;

public class MinSubarrayLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter target value:");
        int target = sc.nextInt();
        System.out.println("Enter number of elements in array:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int minLen = Integer.MAX_VALUE;
        int sum = 0, left = 0;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        if (minLen == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLen);
        }
    }
}
