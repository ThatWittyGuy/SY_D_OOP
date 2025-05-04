import java.io.*;
import java.util.Scanner;

public class FileReaderDemo {

    public static void main(String[] args) {
        String filePath = "sample.txt";

        try {
            countCharsAndWords(filePath);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void countCharsAndWords(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int charCount = 0;
        int wordCount = 0;
        String line;

        // Read the file line by line
        while ((line = bufferedReader.readLine()) != null) {
            charCount += line.length();

            String[] words = line.split("\\s+");
            wordCount += words.length;
        }

        bufferedReader.close();

        System.out.println("Total number of characters: " + charCount);
        System.out.println("Total number of words: " + wordCount);
    }
}
