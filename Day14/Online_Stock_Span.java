package Day14;

import java.util.ArrayDeque;
import java.util.Deque;

public class Online_Stock_Span {
    Deque<int[]> stq = new ArrayDeque<>();

    public int next(int price) {
        int res = 1;

        while (!stq.isEmpty() && stq.peek()[0] <= price)
            res += stq.pop()[1];
        stq.push(new int[]{price, res});

        return res;
    }
}