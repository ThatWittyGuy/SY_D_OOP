import java.util.Scanner;

interface Sortable {
    void sort(int[] arr);
}

class BubbleSort implements Sortable {
    public void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            for(int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.print("Array after Bubble Sort: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

class SelectionSort implements Sortable {
    public void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            int minIdx = i;
            for(int j = i+1; j < n; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        System.out.print("Array after Selection Sort: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

public class SortDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Choose sorting method: 1. Bubble Sort  2. Selection Sort");
        int choice = sc.nextInt();

        Sortable sorter;
        if(choice == 1) {
            sorter = new BubbleSort();
        } else if(choice == 2) {
            sorter = new SelectionSort();
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        sorter.sort(arr);
    }
}
