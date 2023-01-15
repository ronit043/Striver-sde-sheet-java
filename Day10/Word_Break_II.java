package Day10;

import java.util.ArrayList;
import java.util.List;

/*    TC: O(2 ^ n), SC: O(n ^ 2) recursive stack space
We start scanning the sentence from the left. As we find a valid word, we need to check whether the rest of
the sentence can make valid words or not. In some situations the first found word from the left(prefix) can
leave a remaining portion that is not further separable. And this process is recursive because to find out
whether the right portion is separable or not, we need the same logic.

Base case:
If all substrings have been extracted, original string becomes empty so add the answer string to the list.
*/
class Word_Break_II {
   public List<String> wordBreak(String s, List<String> wordDict) {
      List<String> res = new ArrayList<>();
      dfs(wordDict, res, s, "");
      return res;
   }

   void dfs(List<String> dict, List<String> res, String orig, String ans) {
      if (orig.isEmpty()) {
         res.add(ans.trim());
         return;
      }

      for (int i = 1; i <= orig.length(); i++) {
         // Extract substring from 0 to i in prefix variable
         String prefix = orig.substring(0, i);
         // If dictionary contains this prefix, then we check for remaining string
         if (dict.contains(prefix))
            dfs(dict, res, orig.substring(i), ans + prefix + " ");
      }
   }
}