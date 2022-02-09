package Day11;

public class Kth_element_of_2_sorted_arrays {
    public long kthElement(int[] arr1, int[] arr2, int n, int m, int k) {
        int i = 0, j = 0;
        long temp = 0;

        while (k > 0 && i < n && j < m) {
            temp = (arr1[i] < arr2[j]) ? arr1[i++] : arr2[j++];
            k--;
        }
        while (k > 0 && i < n) {
            temp = arr1[i++];
            k--;
        }
        while (k > 0 && j < m) {
            temp = arr2[j++];
            k--;
        }
        return temp;
    }
}