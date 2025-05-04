import java.util.Scanner;

public class ArrayTasks {
    // Find largest and smallest in array
    public static void findMinMax(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }
        int min = arr[0], max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        System.out.println("Smallest: " + min);
        System.out.println("Largest: " + max);
    }

    // Reverse array in place
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Merge two arrays into a single sorted array (no inbuilt sort)
    public static int[] mergeAndSort(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] merged = new int[n1 + n2];
        for (int i = 0; i < n1; i++) merged[i] = arr1[i];
        for (int i = 0; i < n2; i++) merged[n1 + i] = arr2[i];

        // Simple selection sort for demonstration
        for (int i = 0; i < merged.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < merged.length; j++) {
                if (merged[j] < merged[minIdx]) minIdx = j;
            }
            int temp = merged[i];
            merged[i] = merged[minIdx];
            merged[minIdx] = temp;
        }
        return merged;
    }

    // Print array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Find min and max
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        findMinMax(arr);

        // Reverse array
        reverseArray(arr);
        System.out.println("Reversed array:");
        printArray(arr);

        // Merge two arrays and sort
        System.out.println("Enter size of second array:");
        int m = sc.nextInt();
        int[] arr2 = new int[m];
        System.out.println("Enter elements of second array:");
        for (int i = 0; i < m; i++) arr2[i] = sc.nextInt();

        int[] merged = mergeAndSort(arr, arr2);
        System.out.println("Merged and sorted array:");
        printArray(merged);
    }
}
