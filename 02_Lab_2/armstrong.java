import java.util.*;

public class armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number, temp, temp2, rem, result = 0, count = 0;

        System.out.print("Enter a number: ");
        number = sc.nextInt();
        temp = number;
        temp2 = number;

        while (temp2 != 0) {
          temp2 /= 10;
          ++count;
        }

        while (temp != 0)
        {
            rem = temp % 10;
            result += Math.pow(rem, count);
            temp /= 10;
        }

        if(result == number)
            System.out.println(number + " is an Armstrong number");
        else
            System.out.println(number + " is not an Armstrong number");
    }
}

