package Day16;
//    TC: O(2 ^ N), SC: O(N)
class Count_and_say {
   public String countAndSay(int n) {
      String s = "1"; // We initialize our starting string s with "1".

      for (int i = 1; i < n; i++) {
         StringBuilder sb = new StringBuilder(); // We will use sb to store consecutively similar digits.
         // Count the occurrence of each character group, set count = 1
         for (int j = 1, count = 1; j <= s.length(); j++) {
            // If j-th char is different from the previous one, we write all previous chars
            if (j == s.length() || s.charAt(j - 1) != s.charAt(j)) {
               sb.append(count).append(s.charAt(j - 1));
               count = 1; // We set count = 1, on encountering a new group of similar characters
            } else count++; // Otherwise we increase the count of previous group
         }
         s = sb.toString();
      }

      return s;
   }
}