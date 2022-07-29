package Day15;

/*    TC: O(n * n), SC: O(1)
If the string to search is empty then, the index will be 0
If the length of string to search is more than the length to be searched in, return -1
The index of method in Java, will return the index of first occurrence of the string, otherwise returns -1
 */

class StrStr {
   public int strStr(String haystack, String needle) {
      if (needle.isEmpty()) return 0;
      else if (haystack.length() < needle.length()) return -1;
      else return haystack.indexOf(needle);
   }
}