package Day2;
/*
    TC: O(n), SC: O(1)

The idea is to traverse the array and mark the visited elements.
While traversing the array, we use the abs. value of every item as an index and make the value
at this index -ve to mark it visited.

If the item (@ index) was already -ve, then this is the repeating element.

To find missing item, we again traverse the array and look for a +ve value. The index at which
we find the +ve value is our missing number because it's not present in the array.
 */
public class Repeat_and_missing_number {
    public int[] repeatedNumber(int[] A) {
        int miss = 0, repeat = 0, n = A.length;

        for (int i = 0; i < n; i++) {
            int index = Math.abs(A[i]) - 1;
            if (A[index] > 0) A[index] *= -1;
            else repeat = Math.abs(A[i]);
        }
        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                miss = i + 1;
                break;
            }
        }

        return new int[]{repeat, miss};
    }
}