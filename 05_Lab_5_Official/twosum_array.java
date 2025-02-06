import java.util.Scanner;

public class twosum_array {
    public static int[] findTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {}; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = sc.nextInt();

        int[] result = findTwoSum(nums, target);

        if (result.length == 2) {
            System.out.println("Numbers: [" + nums[result[0]] + ", " + nums[result[1]] + "]");
        } else {
            System.out.println("No solution found!");
        }

        sc.close();
    }
}
