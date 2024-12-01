import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    private Trie trie;
    private Deque<Pair<String, String>> queue;

    public Solution() {
        this.trie = new Trie();
        this.queue = new ArrayDeque<>();
    }

    public void buildTrie(String filePath) throws IOException {
        
        //Construct the tree structure & initialises the queue with possible words splits
         
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String word = line.trim();
                List<String> prefixes = trie.getPrefixes(word);
                for (String prefix : prefixes) {
                    queue.add(new Pair<>(word, word.substring(prefix.length())));
                }
                trie.insert(word);
            }
        }
    }

    public Pair<String, String> findLongestCompoundWords() {
        
        //  Finds the longest and second-longest compound words.
         
        String longestWord = "";
        int longestLength = 0;
        String secondLongestWord = "";

        while (!queue.isEmpty()) {
            Pair<String, String> current = queue.poll();
            String word = current.getKey();
            String suffix = current.getValue();

            if (trie.search(suffix)) {
                if (word.length() > longestLength) {
                    secondLongestWord = longestWord;
                    longestWord = word;
                    longestLength = word.length();
                }
            } else {
                List<String> prefixes = trie.getPrefixes(suffix);
                for (String prefix : prefixes) {
                    queue.add(new Pair<>(word, suffix.substring(prefix.length())));
                }
            }
        }

        return new Pair<>(longestWord, secondLongestWord);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        try {
            // Start the timer
            long startTime = System.currentTimeMillis();

            // Build trie and find the longest compound words
            sol.buildTrie("Input_02.txt");
            Pair<String, String> result = sol.findLongestCompoundWords();

            // Stop the timer
            long endTime = System.currentTimeMillis();

            // Calculate the time taken in sec
            double timeTaken = (endTime - startTime) / 1000.0;

            // Print results
            System.out.println("Longest Compound Word: " + result.getKey());
            System.out.println("Second Longest Compound Word: " + result.getValue());
            System.out.println("Time taken: " + timeTaken + " seconds");
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file.");
        }
    }
}

// Helper class (represent a pair of values for the Solution)
class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}