package Day25;

public class Matrix_Chain_Multiplication {
   public int matrixMultiplication(int[] arr, int N) {
      int[][] dp = new int[N][N];

      for (int i = N - 1; i >= 1; i--) {
         for (int j = i + 1; j < N; j++) {
            int mini = (int) 1e9;
            for (int k = i; k < j; k++) {
               int steps = arr[i - 1] * arr[j] * arr[k] + dp[i][k] + dp[k + 1][j];
               mini = Math.min(mini, steps);
            }

            dp[i][j] = mini;
         }
      }

      return dp[1][N - 1];
   }
}