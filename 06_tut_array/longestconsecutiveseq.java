import java.util.*;
class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
       if (arr == null || arr.length == 0) {
            return 0;
        }

        Set<Integer> st = new HashSet<>();
        int res = 0;

        for (int num : arr) {
            st.add(num);
        }

        for (int num : arr) {
            if (!st.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (st.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                res = Math.max(res, currentStreak);
            }
        }

        return res;
    }
}