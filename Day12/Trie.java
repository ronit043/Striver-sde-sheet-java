package Day12;

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i)))
                node.put(word.charAt(i), new TrieNode());

            node = node.get(word.charAt(i));
            node.increasePrefix();
        }

        node.setEnd();
        node.increaseEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i)))
                return false;

            node = node.get(word.charAt(i));
        }

        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i)))
                return false;

            node = node.get(prefix.charAt(i));
        }

        return true;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i)))
                node = node.get(word.charAt(i));
            else return 0;
        }

        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i)))
                node = node.get(word.charAt(i));
            else return 0;
        }

        return node.getPrefix();
    }

    public void erase(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            }
            else return;
        }

        node.deleteEnd();
    }
}