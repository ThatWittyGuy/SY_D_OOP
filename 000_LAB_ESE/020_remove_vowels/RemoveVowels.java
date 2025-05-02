import java.util.Scanner;

public class RemoveVowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter paragraph");
        String paragraph = sc.nextLine();
        StringBuilder sb = new StringBuilder(paragraph);
        int count = 0;
        for (int i = 0; i < sb.length(); ) {
            char ch = sb.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                sb.deleteCharAt(i);
                count++;
            } else {
                i++;
            }
        }
        System.out.println(sb.toString());
        System.out.println(count);
    }
}
