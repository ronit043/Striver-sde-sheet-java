package Day11;

/*      TC: O(N x log(M x 10 ^ d)), SC: O(1)
We apply binary search here, on the range [1, m]. Make a separate function to multiply mid N times.
Run the while loop, till (high – low > eps). Take eps = 1e-6, to find answers to 6 decimal places.

We will take the mid of l and r as (l + r) / 2.0, preventing overflow
Consider the equation x = n√m and solving for m, we get m = (x ^ n)

So, multiply mid n times, and if mid < m, then we move left boundary to mid, else move right boundary to mid.
After the loop breaks we will have our answer as low or high.
 */
class Nth_Root_Integer {
   public double findNthRootOfM(int n, long m) {
      double l = 1, r = m, eps = 1e-6;

      while ((r - l) > eps) {
         double mid = (l + r) / 2.0;
         if (check(mid, n, m))
            l = mid;
         else
            r = mid;
      }

      return l;
   }

   boolean check(double number, int n, long res) {
      double ans = 1.0;
      for (int i = 1; i <= n; i++) ans *= number;
      return ans <= res;
   }
}