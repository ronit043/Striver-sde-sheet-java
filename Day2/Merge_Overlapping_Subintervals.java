package Day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Overlapping_Subintervals {
    public int[][] merge(int[][] itrvl) {
    	Arrays.sort(itrvl, (i1, i2) -> Integer.compare(i1[0], i2[0]));
    	List<int[]> ans = new ArrayList<>();
    	int[] interval = itrvl[0];
    	ans.add(interval);
    	
    	for (int[] itr : itrvl) {
    		if(itr[0] <= interval[1]) 
    			interval[1] = Math.max(interval[1], itr[1]);
    		else {
    			interval = itr;
    			ans.add(interval);
    		}
    	}
    	return ans.toArray(new int[ans.size()][]);
    }
}
