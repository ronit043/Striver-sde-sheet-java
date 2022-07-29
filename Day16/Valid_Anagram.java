package Day16;
/*    TC: O(n), SC: O(1)
Recreate the strings by removing all whitespaces, and converting every character to lowercase.
The idea is to create an ‘alphabet’ array with all the values set to 0. We increment the value in the
‘alphabet’ (of size 26) array for characters in 's' and decrement for characters in ‘t’. Finally, if all
‘alphabet’ array values are 0, then the two strings are anagram.
 */
class Valid_Anagram {
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