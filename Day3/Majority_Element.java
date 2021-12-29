/**
 * Majority_Element
 */
public class Majority_Element {
    public int majorityElement(int[] nums) {
        int counter = 0, majority = 0;
        for (int n : nums) {
            if (counter == 0) majority = n;
            counter += (majority == n) ? 1 : -1;
        }
        return majority;
    }
}