package Day11;

public class Nth_Root_Integer {
    public int NthRoot(int m, int n) {
        int l = 1, r = m;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (Math.pow(mid, n) == m) return mid;
            else if (Math.pow(mid, n) < m) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }
}