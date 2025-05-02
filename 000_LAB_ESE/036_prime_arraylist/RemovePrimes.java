import java.util.ArrayList;
import java.util.Iterator;

public class RemovePrimes {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            list.add(i);
        }

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (isPrime(num)) {
                it.remove();
            }
        }

        System.out.println("ArrayList after removing primes: " + list);
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
