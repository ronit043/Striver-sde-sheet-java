package Day12;

public class TrieNode {
    public boolean isWord;
    public TrieNode[] links = new TrieNode[26];
    public int endWith, countPrefix;
    public TrieNode() {}

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        isWord = true;
    }

    boolean isEnd() {
        return isWord;
    }

    void increaseEnd() { endWith++; }

    void increasePrefix() { countPrefix++; }

    void deleteEnd() {
        endWith--;
    }

    void reducePrefix() {
        countPrefix--;
    }

    int getEnd() {
        return endWith;
    }

    int getPrefix() { return countPrefix; }
}