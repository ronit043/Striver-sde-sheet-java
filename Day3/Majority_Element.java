package Day3;

public class Majority_Element {
    public int majorityElement(int[] election) {
        int vote = 0, majority = 0;
        
        for (int candidate : election) {
            if (vote == 0) majority = candidate;
            vote += (majority == candidate) ? 1 : -1;
        }

        return majority;
    }
}