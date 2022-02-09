package Day14;

import java.util.ArrayDeque;
import java.util.Deque;

public class Celebrity_Problem {
    // Function to find if there's a celebrity in the party or not.
    public int celebrity(int[][] M, int n) {
        Deque<Integer> adq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) adq.push(i);

        while (adq.size() >= 2) {
            int i = adq.pop(), j = adq.pop();
            // i isn't a celebrity
            if (M[i][j] == 1) adq.push(j);
            // j isn't a celebrity
            else adq.push(i);
        }
        int pot = adq.pop(); // When the stack has the last element, it's a potential celebrity
        for (int i = 0; i < n; i++) {
            if (i != pot) {
                if (M[i][pot] == 0 || M[pot][i] == 1) return -1;
            }
        }
        
        return pot;
    }
}