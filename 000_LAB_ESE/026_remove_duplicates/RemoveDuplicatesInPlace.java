import java.util.Scanner;

public class RemoveDuplicatesInPlace {
    public static int removeDuplicates(int[] nums, int n) {
        if (n == 0) return 0;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements in sorted order:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int len = removeDuplicates(nums, n);

        System.out.println("New length: " + len);
        System.out.print("Modified array: ");
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        for (int i = len; i < n; i++) {
            System.out.print("_ ");
        }
    }
}
