package Day15;
import java.util.HashMap;
import java.util.Map;

/*    TC: O(n), SC: O(1)
We simply traverse through the string, till the 2nd last index.

If the current character is less than the value of the next character, we subtract the value of the current
character from the value of the digit of higher value.
If the current character value is more than the next character value, the values of all the digits are added.

At last, add the value of the last character and return.
 */
class Roman_to_integer {
   public int romanToInt(String s) {
      Map<Character, Integer> hm = new HashMap<>();
      hm.put('I', 1);
      hm.put('V', 5);
      hm.put('X', 10);
      hm.put('L', 50);
      hm.put('C', 100);
      hm.put('D', 500);
      hm.put('M', 1000);
      int number = hm.get(s.charAt(s.length() - 1));

      for (int i = s.length() - 1; i > 0; i--) {
         if (hm.get(s.charAt(i)) > hm.get(s.charAt(i - 1)))
            number -= hm.get(s.charAt(i - 1));
         else
            number += hm.get(s.charAt(i - 1));
      }

      return number;
   }
}