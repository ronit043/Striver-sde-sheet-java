package Day14;

import java.util.ArrayDeque;
import java.util.Deque;

public class Next_smaller_element {
    public int[] prevSmaller(int[] A) {
        int[] as = new int[A.length];

        Deque<Integer> adq = new ArrayDeque<>();
        for(int i = 0; i < A.length; i++) {
            while(!adq.isEmpty() && adq.peek() >= A[i]) adq.pop();
            int nsl = adq.isEmpty() ? -1 : adq.peek();
            as[i] = nsl;
            adq.push(A[i]);
        }

        return as;
    }
}