import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;
    }

    public List<String> getPrefixes(String word) {
        TrieNode current = root;
        List<String> prefixes = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) break;

            prefix.append(c);
            current = current.children.get(c);
            if (current.isEndOfWord) {
                prefixes.add(prefix.toString());
            }
        }
        return prefixes;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) return false;
            current = current.children.get(c);
        }
        return current.isEndOfWord;
    }
}