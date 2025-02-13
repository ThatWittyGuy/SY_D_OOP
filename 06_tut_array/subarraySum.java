import java.util.*;
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        int currentSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            while (currentSum > target) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == target) {
                result.add(start + 1);
                result.add(i + 1);
                return result;
            }
        }

        result.add(-1);
        return result;
    }
}