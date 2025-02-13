import java.util.Arrays;

class secondMax {
    
    // function to find the second largest element in the array
    static int getSecondLargest(int[] arr) {
        int n = arr.length;

        int largest = -1, secondLargest = -1;

        for (int i = 0; i < n; i++) {

            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
          
            else if(arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println(getSecondLargest(arr));
    }
}