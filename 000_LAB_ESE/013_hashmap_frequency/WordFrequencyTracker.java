import java.util.*;

public class WordFrequencyTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<String>> freqWords = new TreeMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            String[] parts = line.split("\\s+");
            String cmd = parts[0];

            if (cmd.equals("add")) {
                String word = parts[1];
                int oldFreq = freq.getOrDefault(word, 0);
                int newFreq = oldFreq + 1;
                freq.put(word, newFreq);

                if (oldFreq > 0) {
                    TreeSet<String> set = freqWords.get(oldFreq);
                    set.remove(word);
                    if (set.isEmpty()) freqWords.remove(oldFreq);
                }
                freqWords.computeIfAbsent(newFreq, k -> new TreeSet<>()).add(word);

            } else if (cmd.equals("remove")) {
                String word = parts[1];
                int oldFreq = freq.getOrDefault(word, 0);
                if (oldFreq > 0) {
                    int newFreq = oldFreq - 1;
                    freq.put(word, newFreq);

                    TreeSet<String> set = freqWords.get(oldFreq);
                    set.remove(word);
                    if (set.isEmpty()) freqWords.remove(oldFreq);

                    if (newFreq > 0) {
                        freqWords.computeIfAbsent(newFreq, k -> new TreeSet<>()).add(word);
                    } else {
                        freq.remove(word);
                    }
                }

            } else if (cmd.equals("query")) {
                String word = parts[1];
                int f = freq.getOrDefault(word, 0);
                System.out.println("Frequency of '" + word + "': " + f);

            } else if (cmd.equals("mostFrequent")) {
                if (freqWords.isEmpty()) {
                    System.out.println("Most frequent word: ");
                } else {
                    int maxFreq = freqWords.lastKey();
                    String minWord = freqWords.get(maxFreq).first();
                    System.out.println("Most frequent word: " + minWord);
                }
            }
        }
    }
}
