// User function Template for Java
class missingNumber {
    int missingNumber(int arr[]) {
        int n = arr.length + 1;

        int[] hash = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}