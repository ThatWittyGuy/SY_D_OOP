import java.util.Scanner;

class CaesarCipher {
    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String shiftedAlphabet;
    private int mainKey;

    public CaesarCipher(int key) {
        mainKey = key;
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }

    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : input.toCharArray()) {
            char up = Character.toUpperCase(ch);
            int idx = alphabet.indexOf(up);
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.append(Character.isLowerCase(ch) ? Character.toLowerCase(newChar) : newChar);
            } else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }

    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }
}

public class TestCaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Caesar Cipher with key");
        System.out.print("Enter text to encrypt: ");
        String input = sc.nextLine();
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted = cc.encrypt(input);
        System.out.println("Encrypted text: " + encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("Decrypted text: " + decrypted);
        sc.close();
    }
}
