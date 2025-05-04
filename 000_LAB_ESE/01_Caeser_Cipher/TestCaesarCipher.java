import java.util.Scanner;


public class TestCaesarCipher {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);


       System.out.print("Enter a message to encrypt: ");
       String message = scanner.nextLine();


       CaesarCipher cipher = new CaesarCipher(18);
       String encrypted = cipher.encrypt(message);
       System.out.println("Encrypted Message: " + encrypted);


       String decrypted = cipher.decrypt(encrypted);
       System.out.println("Decrypted Message: " + decrypted);


       scanner.close();
   }
}
