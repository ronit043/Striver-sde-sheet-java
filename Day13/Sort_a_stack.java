package Day13;

class Sort_a_stack {
    public Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> stq = new Stack<>();
        stq.push(s.pop());

        while (!s.empty()) {
            if (s.peek() < stq.peek()) {
                int t1 = s.pop(), t2 = stq.peek();
                while (t2 > t1 && !stq.empty()) {
                    s.push(t2);
                    stq.pop();
                    if (!stq.empty()) t2 = stq.peek();
                }
                stq.push(t1);
            } 
            else
                stq.push(s.pop());
        }

        return stq;
    }
}