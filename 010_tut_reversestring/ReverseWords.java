import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        System.out.println("Reversed words:\n" + reverseWords(input));
    }

    public static String reverseWords(String str) {
        String result = "";
        String word = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                result += reverseWord(word) + " ";
                word = "";
            } else {
                word += ch;
            }
        }
        result += reverseWord(word); 
        return result;
    }

    public static String reverseWord(String word) {
        String reversedWord = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }
        return reversedWord;
    }
}
