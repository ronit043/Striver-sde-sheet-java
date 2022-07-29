package Day14;

/*    TC: O(n), SC: O(1)
If i knows j, that means i is not the celebrity because a celebrity doesn’t know anyone. If i doesn’t know j,
that means j is not the celebrity because everyone knows the celebrity.

Go through all the celebrities indexes i [0, n), if possible_celeb knows i, then current possible_celeb isn't
the celebrity and set the current index as the celebrity.

At last check, if possible_celeb is a celebrity, by passing possible_celeb and n in the isCeleb method.
 */
class Celebrity_Problem {
   public int findCelebrity(int n) {
      int possible_celeb = 0;

      for (int i = 0; i < n; i++)
         if (knows(possible_celeb, i)) possible_celeb = i;

      return isCeleb(possible_celeb, n) ? possible_celeb : -1;
   }

   boolean isCeleb(int possible_celeb, int n) {
      for (int j = 0; j < n; j++) {
         if (possible_celeb == j) continue;
         if (knows(possible_celeb, j) || !knows(j, possible_celeb)) return false;
      }
      return true;
   }

   boolean knows(int i, int celeb) { return false; }
}