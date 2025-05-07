import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFileCount {
    public static void main(String[] args) {
        String fileName = "sample.txt";
        FileInputStream fis = null;
        int charCount = 0;
        int wordCount = 0;

        try {
            // Check if file exists, if not create it with default content
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found. Creating " + fileName + " with sample content...");
                FileOutputStream fos = new FileOutputStream(file);
                String defaultContent = "This is an input file.\nIt is made by Radha.";
                fos.write(defaultContent.getBytes());
                fos.close();
            }

            fis = new FileInputStream(file);
            StringBuilder content = new StringBuilder();

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                char c = (char) byteRead;
                content.append(c);
                charCount++;
            }

            // Trim and split the content to count words
            String text = content.toString().trim();
            if (!text.isEmpty()) {
                String[] words = text.split("\\s+"); 
                wordCount = words.length;
            }

            System.out.println("Number of characters: " + charCount);
            System.out.println("Number of words: " + wordCount);

        } catch (IOException e) {
            System.out.println("An error occurred while processing the file: " + e.getMessage());
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                System.out.println("Failed to close the file input stream.");
            }
        }
    }
}
