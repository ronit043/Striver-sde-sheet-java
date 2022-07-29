package Day15;
/*    TC: O(n), SC: O(1)
The simple approach would be first creating two arrays, one array with ints which represent the numbers and
another string array which represent the roman string at respective index - matching with int val array.

Then we will run a loop till the number exceeds 0. Within the loop until the num >= current val
when relevant number found in val array, we will subtract it from num and append the ans with appropriate
roman numeral.
 */
public class Integer_to_roman {
   public String intToRoman(int num) {
      int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
      String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
      StringBuilder ans = new StringBuilder();
      if (num < 1 || num > 3999) return "";

      for (int i = 0; num > 0; i++) {
         while (num >= val[i]) {
            num -= val[i];
            ans.append(roman[i]);
         }
      }

      return ans.toString();
   }
}