import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements to add:");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            String value = sc.nextLine();
            list.add(value);
        }

        System.out.println("Traverse using for-loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println("Traverse using Iterator:");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("Traverse using advanced for-loop:");
        for (String val : list) {
            System.out.println(val);
        }

        System.out.println("Enter element to search:");
        String search = sc.nextLine();
        if (list.contains(search)) {
            System.out.println("Element exists in ArrayList.");
        } else {
            System.out.println("Element does not exist in ArrayList.");
        }

        System.out.println("Enter element to add:");
        String newElem = sc.nextLine();
        System.out.println("Enter index to add at:");
        int idx = sc.nextInt();
        if (idx >= 0 && idx <= list.size()) {
            list.add(idx, newElem);
            System.out.println("Element added. Updated ArrayList:");
            for (String val : list) {
                System.out.println(val);
            }
        } else {
            System.out.println("Invalid index.");
        }
    }
}


// REMOVE PRIME
// import java.util.ArrayList;
// import java.util.Iterator;

// public class RemovePrimes {
//     public static void main(String[] args) {
//         ArrayList<Integer> list = new ArrayList<>();
//         for (int i = 1; i <= 25; i++) {
//             list.add(i);
//         }

//         Iterator<Integer> it = list.iterator();
//         while (it.hasNext()) {
//             int num = it.next();
//             if (isPrime(num)) {
//                 it.remove();
//             }
//         }

//         System.out.println("ArrayList after removing primes: " + list);
//     }

//     static boolean isPrime(int n) {
//         if (n < 2) return false;
//         for (int i = 2; i <= Math.sqrt(n); i++) {
//             if (n % i == 0) return false;
//         }
//         return true;
//     }
// }
