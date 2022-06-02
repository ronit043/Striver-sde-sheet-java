package Day3;

/*
    TC : O(n), SC : O(1)

The idea is similar to merge sort, divide the array from the middle to two parts, say, left and right sub-array

We write logic that counts the number of inversions when the arrays, left and right are merged.
Have two indices. One of the indices will refer to the left and other to the right sub-array.

We can say, there would be ('MID' - ‘LEFT_INDEX’) inversions, where ‘MID’ is the index from where the array has
been split into two. We can say so because all the remaining elements in the left sub-array will be greater
than right sub-array.
 */

public class Count_Inversions {
    long getInversions(long[] arr, int n) {
        return countInv(arr, 0, n - 1);
    }

    long countInv(long[] arr, int l, int r) {
        long res = 0;
        if (l < r) {
            int m = (l + r) / 2;
            res += countInv(arr, l, m) + countInv(arr, m + 1, r) +
                    countNMerge(arr, l, m + 1, r);
        }
        return res;
    }

    long countNMerge(long[] arr, int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        long invCount = 0, temp[] = new long[(right - left + 1)];

        while (i < mid && j <= right) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                invCount += (mid - i);
            }
        }

        while (i < mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (i = left, k = 0; i <= right; i++, k++) arr[i] = temp[k];

        return invCount;
    }
}