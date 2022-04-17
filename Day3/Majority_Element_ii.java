package Day3;

import java.util.ArrayList;
import java.util.List;

public class Majority_Element_ii {
    public List<Integer> majorityElement(int[] nums) {
        int maj1 = -1, maj2 = -1, vote1 = 0, vote2 = 0, thresh = nums.length / 3;
        List<Integer> al = new ArrayList<>();

        for (int i : nums) {
            if (i == maj1) vote1++;
            else if (i == maj2) vote2++;
            else if (vote1 == 0) { vote1 = 1; maj1 = i; } 
            else if (vote2 == 0) { vote2 = 1; maj2 = i; } 
            else { vote1--; vote2--; }
        }

        vote1 = 0; vote2 = 0;
        for (int i : nums) {
            if (i == maj1) vote1++;
            else if (i == maj2) vote2++;
        }

        if (vote1 > thresh) al.add(maj1);
        if (vote2 > thresh) al.add(maj2);

        return al; 
    } 
}