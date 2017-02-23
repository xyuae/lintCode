/**
 * Created by Xiaojun YU on 2017-02-22.
 */
public class ImplementTrie {
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie trie = new Trie();
     * trie.insert("lintcode");
     * trie.search("lint"); will return false
     * trie.startsWith("lint"); will return true
     */
    class TrieNode {
        // Initialize your data structure here.
        private TrieNode[] list;
        private boolean isWord;
        public TrieNode() {
            list= new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;


        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            if (word == null || word.length() == 0) return;
            // get a copy of root;
            TrieNode tempRoot = root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                int num = letter - 'a';
                if (tempRoot.list[num] == null) tempRoot.list[num] = new TrieNode();
                // go to the next TrieNode level
                tempRoot = tempRoot.list[num];
            }
            tempRoot.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            if (word == null || word.length() == 0) return false;
            // get a copy of root;
            TrieNode tempRoot = root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                int num = letter - 'a';
                if (tempRoot.list[num] == null) return false;
                // go to the next TrieNode level
                tempRoot = tempRoot.list[num];
            }
            if (tempRoot.isWord) return true;
            return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) return true;
            // get a copy of root;
            TrieNode tempRoot = root;
            for (int i = 0; i < prefix.length(); i++) {
                char letter = prefix.charAt(i);
                int num = letter - 'a';
                if (tempRoot.list[num] == null) return false;
                // go to the next TrieNode level
                tempRoot = tempRoot.list[num];
            }
            return true;
        }
    }
}
