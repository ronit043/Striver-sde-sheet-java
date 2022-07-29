package Day13;
import java.util.Stack;

public class Implement_queue_using_stacks {
   Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>();

   // Push item x to the back of queue.
   public void push(int x) {
      while (!s1.isEmpty()) s2.push(s1.pop());
      s1.push(x);
      while (!s2.isEmpty()) s1.push(s2.pop());
   }

   // Removes the item from in front of queue and returns that item.
   public int pop() {
      if (s1.isEmpty()) System.exit(0);
      int x = s1.peek();
      s1.pop();
      return x;
   }

   // Get the front item.
   public int peek() {
      if (s1.isEmpty()) System.exit(0);
      return s1.peek();
   }

   // Returns whether the queue is empty.
   public boolean empty() { return s1.isEmpty(); }
}