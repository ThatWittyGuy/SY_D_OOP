import java.util.*;

public class Hashmap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> freqMap = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;

            String[] parts = line.split(" ");
            String command = parts[0];

            switch (command) {
                case "add":
                    String wordToAdd = parts[1];
                    freqMap.put(wordToAdd, freqMap.getOrDefault(wordToAdd, 0) + 1);
                    break;

                case "remove":
                    String wordToRemove = parts[1];
                    freqMap.put(wordToRemove, Math.max(freqMap.getOrDefault(wordToRemove, 0) - 1, 0));
                    break;

                case "query":
                    String wordToQuery = parts[1];
                    System.out.println("Frequency of '" + wordToQuery + "': " + freqMap.getOrDefault(wordToQuery, 0));
                    break;

                case "mostFrequent":
                    int maxFreq = 0;
                    String mostFreqWord = "";
                    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
                        String word = entry.getKey();
                        int freq = entry.getValue();
                        if (freq > maxFreq || (freq == maxFreq && word.compareTo(mostFreqWord) < 0)) {
                            maxFreq = freq;
                            mostFreqWord = word;
                        }
                    }
                    if (maxFreq > 0)
                        System.out.println("Most frequent word: " + mostFreqWord);
                    else
                        System.out.println("No words found");
                    break;

                default:
                    System.out.println("Invalid command");
            }
        }

        sc.close();
    }
}
