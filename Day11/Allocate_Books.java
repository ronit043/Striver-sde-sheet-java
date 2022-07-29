package Day11;
import java.util.Arrays;

/*    TC: O(N * log(M – max)); N: #books, max: maximum #pages, M: sum of #pages
      SC: O(1)

We know that our answer could be between maximum of all available pages and the sum of all pages. Now we will
use binary search to find answer. If mid is a solution, then we search on the left half (minimising pages),
else on right half (maximising pages).

We need to check if we can assign pages to all students in a way that the current #students <= #max_students.
To do this, we sequentially assign pages to every student. Lastly we check the current #assigned_students
doesn’t exceed the maximum #students.
 */
public class Allocate_Books {
   public int books(int[] books, int max_students) {
      if (max_students > books.length) return -1;
      int l = Arrays.stream(books).max().orElseThrow(), r = Arrays.stream(books).sum(), ans = -1;

      while (l <= r) {
         int mid = l + (r - l) / 2;
         if (isFeasible(books, max_students, mid)) {
            ans = mid;
            r = mid - 1;
         } else l = mid + 1;
      }

      return ans;
   }

   boolean isFeasible(int[] books, int max_students, int min_page) {
      int student = 1, sum_of_pages = 0;

      for (int page : books) {
         sum_of_pages += page;
         if (sum_of_pages > min_page) {
            student++;
            sum_of_pages = page;
         }
      }

      return student <= max_students;
   }
}