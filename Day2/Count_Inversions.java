package Day2;

import java.util.Arrays;

public class Count_Inversions {
    static long getInversions(long[] arr, int n) {
        return countInv(arr, 0, n - 1);
    }

    static long countInv(long[] arr, int l, int r) {
        long res = 0;
        if (l < r) {
            int m = (r + l) / 2;
            res += countInv(arr, l, m);
            res += countInv(arr, m + 1, r);
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }

    static long countAndMerge(long[] arr, int l, int m, int r) {
        long res = 0;
        long[] left = Arrays.copyOfRange(arr, l, m + 1), right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l, n1 = left.length, n2 = right.length;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                res += (n1 - i);
            }
        }
        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
        return res;
    }
}