package Day16;

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        s = s.replace("\\s", "").toLowerCase();
        t = t.replace("\\s", "").toLowerCase();

        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;

        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
}