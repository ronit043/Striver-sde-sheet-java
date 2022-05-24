package Day2;
/*
    TC: O(m + n); SC: O(1)

Solution

We take three references
    1. Last index of the first array that need to be swapped (i = m - 1).
    2. Last index of the second array (j = n - 1).
    3. Last index of the first array (k = m + n - 1).

Using an approach similar to merge sort but here we fill larger(i.e. compared) elements from the back.
If any index goes OutOfBounds then there should be items in the other array(other index >= 0), so copy the
rest of the items, since both the given array are sorted.

*/
public class Merge_two_arrays_without_extra_space {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;

        while(i >= 0 && j >= 0) 
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
    
        while(j >= 0) 
            nums1[k--] = nums2[j--];

        while(i >= 0)
            nums1[k--] = nums1[i--];
    } 
}
