package Day15;
import java.util.Arrays;

/*    TC : O(M * N * log(M)), N: #strings & M: shortest length of the string present in the array.
      SC : O(1)
The idea is to apply binary search method to find the string with maximum value L, which is common prefix of
all the strings. Search space is [0 … minLen], where minLen is minimum string length and the maximum
possible common prefix. Each time search space is divided in two equal parts, one of them is discarded,
because it's certain that it doesn't contain the solution. There are two possible cases:

1. S[1...mid] is not a common string. This means that for each j > i S[1 ... j] is not a common string, and
we discard the second half of the search space.

2. S[1...mid] is common string. This means that for each i < j S[1 ... i] is a common string, and we discard
the first half of the search space, because we try to find longer common prefix.
 */
class Longest_common_prefix {
   public String longestCommonPrefix(String[] strings) {
      if (strings.length == 0) return "";
      int l = 1, r = Arrays.stream(strings).map(String::length).min(Integer::compare).get();
      while (l <= r) {
         int mid = l + (r - l) / 2;
         if (isCommonPrefix(strings, mid)) l = mid + 1;
         else r = mid - 1;
      }
      return strings[0].substring(0, (l + r) / 2);
   }

   boolean isCommonPrefix(String[] strings, int len) {
      String prefix = strings[0].substring(0, len);
      for (int i = 1; i < strings.length; i++)
         if (strings[i].indexOf(prefix) != 0) return false;
      return true;
   }
}