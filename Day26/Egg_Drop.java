package Day26;

public class Egg_Drop {
   public int eggDrop(int A, int B) {
      int dp[] = new int[A + 1], m;

      for (m = 0; dp[A] < B; m++) {
         for (int egg = A; egg > 0; egg--)
            dp[egg] = dp[egg - 1] + dp[egg] + 1;
      }

      return m;
   }
}