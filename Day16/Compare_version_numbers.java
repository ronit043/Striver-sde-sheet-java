package Day16;

class Compare_version_numbers {
   public int compareVersion(String v1, String v2) {
      for (int i = 0, j = 0; i < v1.length() || j < v2.length(); i++, j++) {
         int num1 = 0, num2 = 0;
         while (i < v1.length() && v1.charAt(i) != '.') {
            num1 = (num1 * 10) + v1.charAt(i) - '0';
            i++;
         }
         while (j < v2.length() && v2.charAt(j) != '.') {
            num2 = (num2 * 10) + v2.charAt(j) - '0';
            j++;
         }
         return (num1 > num2) ? 1 : -1;
      }
      return 0;
   }
}