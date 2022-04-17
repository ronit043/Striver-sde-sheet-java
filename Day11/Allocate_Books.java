package Day11;

import java.util.Arrays;

public class Allocate_Books {
    public int books(int[] arr, int k) {
        int l = Arrays.stream(arr).max().getAsInt(), r = Arrays.stream(arr).sum(), ans = -1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isFeasible(arr, k, m)) {
                ans = m;
                r = m - 1;
            }
            else l = m + 1;
        }

        return ans;
    }

    boolean isFeasible(int[] books, int k, int res) {
        int stud = 1, sum = 0;
        for (int book : books) {
            if (sum + book > res) {
                stud++;
                sum = book;
            }
            else sum += book;
        }
        return stud <= k;
    }
}