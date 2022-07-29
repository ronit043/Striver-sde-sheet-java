package Day15;
/*    TC: O(n), SC: O(1)
Skip all leading whitespaces in the input string. Initialize two variables:
sign (to store the sign of the final result) as 1, base as 0.

Check if the current character is a '+' or '-' sign:
. If the current character is '+', keep sign = 1.
. If the current character is '-', change sign to -1.
. Else break

Iterate over the characters in the string till the current character represents a digit or until we reach the
end of the string. Create the currently selected digit. If the 32-bit signed integer range is violated.
If it is violated, then return INT_MAX or INT_MIN as appropriate.

Return the final result with its respective sign, sign * result.
 */
public class String_To_Integer {
   public int myAtoi(String s) {
      int i = 0, sign = 1;
      long base = 0L;

      while (i < s.length() && s.charAt(i) == ' ') i++; // Skip whitespaces
      if (i >= s.length()) return 0;

      switch (s.charAt(i)) {
         case '-': sign = -1; // Negative number, flip sign
         case '+': i++; // Positive number, increment index
         default: break;
      }

      for (; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
         base = base * 10 + (s.charAt(i) - '0');
         if (base > Integer.MAX_VALUE)
            return (sign > 0) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      }

      return sign * (int) base;
   }
}