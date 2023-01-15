package Day03;

/*    TC : O(log(n)), SC : O(1)

Initialise exp(type: long) as the absolute value of n preventing overflow, since the function expects
a double initialise a double value as 1.

Perform below operations till exp > 0 :
If exp is odd, multiply ans with base or x. We then divide exp by 2 and multiply x with itself.

Return ans (if n >= 0) otherwise (1 / ans).
 */
class Pow_x_n {
   public double myPow(double x, int n) {
      long exp = Math.abs((long) n);
      double ans = 1;

      while (exp > 0) {
         if ((exp % 2) == 1) ans *= x;
         exp /= 2;
         x *= x;
      }

      return n >= 0 ? ans : (1 / ans);
   }
}