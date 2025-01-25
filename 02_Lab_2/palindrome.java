import java.util.*;

public class palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number, temp, rem, result = 0;

        System.out.print("Enter a number: ");
        number = sc.nextInt();
        temp = number;

        while (temp != 0)
        {
            rem = temp % 10;
            result = result*10 +rem;
            temp /= 10;
        }

        if(result == number)
            System.out.println(number + " is Palindrome");
        else
            System.out.println(number + " is not Palindrome");
    }
}

