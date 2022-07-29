package Day16;
/*
The idea here is to concatenate both 'S' and 'P' and make a string “P$S”, where ‘$’ is a special character
that we are using. Now, for this concatenated string we will make a Z array. In this Z array, if the value
at any index(z[i]) is equal to ‘M', we return i - m - 1. Otherwise return -1.
 */
class Z_Function {
   int[] z_function(String s) {
      int n = s.length();
      int[] z = new int[n];

      for (int i = 1, l = 0, r = 0; i < n; ++i) {
         if (i <= r) z[i] = Math.min(r - i + 1, z[i - l]);
         while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) ++z[i];
         if (i + z[i] - 1 > r) {
            l = i;
            r = i + z[i] - 1;
         }
      }

      return z;
   }
   public int strStr(String haystack, String needle) {
      int n = haystack.length(), m = needle.length();
      if (m == 0) return 0;
      String res = needle + "$" + haystack; // we find the z array for [pat + '$' + text]
      int[] z = z_function(res);
      for (int i = 0; i < res.length(); i++) if (z[i] == m) return i - m - 1;
      return -1;
   }
}