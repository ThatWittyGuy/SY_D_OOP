public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
 
 
    // Constructor
    public CaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
 
 
    // Encrypt method
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            char upperChar = Character.toUpperCase(currChar);
            int idx = alphabet.indexOf(upperChar);
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                // Preserve case
                if (Character.isLowerCase(currChar)) {
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }
 
 
    // Decrypt method
    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }
 }
 