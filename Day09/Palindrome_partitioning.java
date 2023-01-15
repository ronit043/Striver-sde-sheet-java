package Day09;
import java.util.List;
import java.util.ArrayList;

/*      TC: O((2 ^ n) * k * (n / 2)), SC: O(n)
The idea is to generate all possible substrings of a given string and expand each possibility if it's a
palindrome. The first thing that comes to our mind is recursion. In the recursive function:

1. Iteratively generate all possible substrings beginning at start index. The end index increments from
start till the end of the string.
2. For each of the substring generated, check if it is a palindrome.
3. If it is, the substring is a potential candidate. Add substring to the list and explore the substring.
If current string ends at "end", end + 1 becomes the start index for the next call.
4. Backtrack if start index is == the string length and add the al to the result.
 */
class Palindrome_partitioning {
   public List<List<String>> partition(String s) {
      List<List<String>> res = new ArrayList<>();
      dfs(res, new ArrayList<>(), s, 0);
      return res;
   }

   void dfs(List<List<String>> res, List<String> al, String s, int start) {
      if (start == s.length()) { res.add(new ArrayList<>(al)); return; }

      for (int end = start; end < s.length(); end++) {
         if (!isPalindrome(s, start, end)) continue;
         al.add(s.substring(start, end + 1));
         dfs(res, al, s, end + 1);
         al.remove(al.size() - 1);
      }
   }

   boolean isPalindrome(String s, int l, int r) {
      while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
      return true;
   }
}