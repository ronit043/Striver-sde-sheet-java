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
public class Roman_to_integer {
   public int romanToInt(String s) {
      Map<Character, Integer> map = new HashMap<>();
      map.put('I', 1);
      map.put('V', 5);
      map.put('X', 10);
      map.put('L', 50);
      map.put('C', 100);
      map.put('D', 500);
      map.put('M', 1000);
      int number = map.get(s.charAt(s.length() - 1));

      for (int i = s.length() - 1; i > 0; i--) {
         if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1)))
            number -= map.get(s.charAt(i - 1));
         else
            number += map.get(s.charAt(i - 1));
      }

      return number;
   }
}