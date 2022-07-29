package Day13;
import java.util.*;

public class Implement_stack_using_queue {
      Deque<Integer> adq = new ArrayDeque<>();

      // Push item x onto stack.
      public void push(int x) { adq.addFirst(x); }

      // Removes the item on top of the stack and return that item.
      public int pop() { return adq.pollFirst(); }

      // Get the top item.
      public int top() { return adq.peekFirst(); }

      // Returns whether the stack is empty.
      public boolean empty() { return adq.isEmpty(); }
}
