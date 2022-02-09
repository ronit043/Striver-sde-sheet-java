package Day9;

import java.util.ArrayList;

public class Subset_Sums {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> res = new ArrayList<>();
        helper(arr, res, 0, 0);
        return res;
    }
    void helper(ArrayList<Integer> arr, ArrayList<Integer> res, int i, int sum) {
        if(i == arr.size()) {
            res.add(sum); 
            return; 
        }
        // Pick the element 
        helper(arr, res, i + 1, sum + arr.get(i)); 
        // Do-not pick the element
        helper(arr, res, i + 1, sum);
    }
}