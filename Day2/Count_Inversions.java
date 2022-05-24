package Day2;
/*
    TC : O(nlog(n)), SC : O(n)

    The idea is similar to merge sort, divide the array from the middle to two parts, left sub-array and
    right sub-array. The idea is to have two pointers. One of the pointers will refer to the left
    sub-array(i) and the other one will point to the right sub-array(j).

    If an item on the left pointer is greater than just copy from left half as it won't give inversions, otherwise
    copy the items from the right and increase the inv. count by adding diff. b/w mid and i. Because all items
    to the right of left-pointer and before mid can form inversion pairs.

    If there are items left, then copy them after that reconstruct the given array by copying items from temp
    to given array and return inversion count.
 */
public class Count_Inversions {
    static long countAndMerge(long[] arr, int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        long invCount = 0, temp[] = new long[(right - left + 1)];

        while ((i < mid) && (j <= right)) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                invCount += (mid - i);
            }
        }
        while (i < mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        for (i = left; i <= right; i++, k++) arr[i] = temp[k];

        return invCount;
    }

    static long countInv(long[] arr, int l, int r) {
        long res = 0;

        if (l < r) {
            int m = (l + r) / 2;
            res += countInv(arr, l, m);
            res += countInv(arr, m + 1, r);
            res += countAndMerge(arr, l, m + 1, r);
        }

        return res;
    }
    static long getInversions(long[] arr, int n) { return countInv(arr, 0, n - 1); }
}