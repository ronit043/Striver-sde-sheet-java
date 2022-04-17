package Day15;

public class Reverse_words_in_a_string {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--)
            ans.append(words[i]).append(" ");

        return ans.toString().trim();
    }
}