package Day15;
/*    TC: O(n), SC: O(1)
If the string is empty return an empty string. Initialize a StringBuilder ans to store the reversed string.
Initialize an index to the string end and run a while loop until the index reaches the start of the string.
In the iteration:

Skip multiple spaces by decreasing the start. Add space between words. Run a loop for extracting word.
Add current word to the answer. After the iteration is over, we return the ans as String.
 */
public class Reverse_words_in_a_string {
   public String reverseWords(String s) {
      if (s.isEmpty() || (s.length() == 1 && s.charAt(0) == ' ')) return s;
      StringBuilder ans = new StringBuilder();
      int start = s.length() - 1;

      while (start >= 0) {
         if (s.charAt(start) == ' ') start--;
         if (ans.length() > 0) ans.append(" ");
         int j = start;
         while (j >= 0 && s.charAt(j) != ' ') j--;
         ans.append(s, j + 1, start + 1);
         start = j;
      }

      return ans.toString();
   }
}