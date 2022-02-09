package Day14;

import java.util.Stack;

public class Min_Stack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> s = new Stack<>();

    public void push(int x) {
        if (x <= min) {
            s.push(min);
            min = x;
        }
        s.push(x);
    }

    public void pop() {
        if (s.pop() == min)
            min = s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}
