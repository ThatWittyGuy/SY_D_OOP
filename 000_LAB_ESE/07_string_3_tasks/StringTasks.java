import java.util.Scanner;

public class StringTasks {
    // Check if a string is a palindrome
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // Count occurrences of a character
    public static int countChar(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                count++;
        }
        return count;
    }

    // Remove all whitespace from a string
    public static String removeWhitespace(String s) {
        char[] result = new char[s.length()];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && s.charAt(i) != '\t' && s.charAt(i) != '\n') {
                result[idx] = s.charAt(i);
                idx++;
            }
        }
        return new String(result, 0, idx);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Palindrome check
        System.out.println("Enter a string to check palindrome:");
        String str1 = sc.nextLine();
        if (isPalindrome(str1))
            System.out.println("Palindrome");
        else
            System.out.println("Not palindrome");

        // Count character
        System.out.println("Enter a string to count character:");
        String str2 = sc.nextLine();
        System.out.println("Enter character to count:");
        char ch = sc.next().charAt(0);
        int count = countChar(str2, ch);
        System.out.println("Occurrences of '" + ch + "': " + count);

        sc.nextLine(); // clear buffer

        // Remove whitespace
        System.out.println("Enter a string to remove whitespace:");
        String str3 = sc.nextLine();
        String noSpace = removeWhitespace(str3);
        System.out.println("String without whitespace: " + noSpace);
    }
}
