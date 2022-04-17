package Day11;

import java.util.ArrayList;

public class Median_of_row_wise_sorted_matrix {
    public int countSmallerThanMid(ArrayList<Integer> row, int val) {
        int l = 0, r = row.size() - 1;

        while(l <= r) {
            int m = (l + r) >> 1;
            if(row.get(m) <= val) l = m + 1;
            else r = m - 1;
        }

        return l;
    }
    
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;
        int n = A.size(), m = A.get(0).size();

        while(l <= r) {
            int mid = (l + r) >> 1, cnt = 0;
            
            for (ArrayList<Integer> lists : A)
                cnt += countSmallerThanMid(lists, mid);

            if(cnt <= (n * m) / 2) l = mid + 1;
            else r = mid - 1;
        }

        return l;
    }
}