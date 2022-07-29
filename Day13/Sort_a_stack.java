package Day13;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*    TC: O(n), SC: O(n)
Use a min heap to store smallest items on top, pop the item from the stack and add it to the heap till
the stack isn't empty.

Now, poll the item from the heap and push it on the stack, the removal from the heap will be sorted, since
it's a min heap. Now push the items one by one, till the heap isn't empty.
 */
class Sort_a_stack {
   public void sortStack(Stack<Integer> s) {
      Queue<Integer> pq = new PriorityQueue<>();

      while (!s.isEmpty())
         pq.add(s.pop());

      while (!pq.isEmpty())
         s.push(pq.poll());
   }
}