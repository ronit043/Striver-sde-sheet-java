import java.util.ArrayList;
import java.util.List;

public class Majority_Element_ii {
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = -1, maj2 = -1, occ1 = 0, occ2 = 0, thresh = nums.length / 3;
        for (int i : nums) {
            if (i == maj1) occ1++;
            else if (i == maj2) occ2++;
            else if (occ1 == 0) { occ1 = 1; maj1 = i; } 
            else if (occ2 == 0) { occ2 = 1; maj2 = i; } 
            else { occ1--; occ2--; }
        }
        List<Integer> al = new ArrayList<>();
        occ1 = 0; occ2 = 0;
        for (int i : nums) {
            if (i == maj1) occ1++;
            else if (i == maj2) occ2++;
        }
        if (occ1 > thresh) al.add(maj1);
        if (occ2 > thresh) al.add(maj2);
        return al; 
    } 
}