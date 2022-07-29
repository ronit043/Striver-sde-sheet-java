package Day14;

import java.util.Stack;

/*    TC: O(n), SC: O(n)
Let’s take a variable that stores the minimum number. So whenever a push operation comes in just take that
number put it in the stack and update the variable to the number.
 */
class Min_Stack {
   Stack<Integer> stq = new Stack<>();
   int mini;
   Min_Stack() {
      mini = Integer.MAX_VALUE;
   }

   void push(int value) {
      if (stq.isEmpty()) {
         mini = value;
         stq.push(value);
      } else {
         if (value < mini) {
            stq.push(2 * value - mini);
            mini = value;
         } else
            stq.push(value);
      }
   }

   void pop() {
      if (stq.isEmpty()) return;

      int val = stq.pop();
      if (val < mini)
         mini = 2 * mini - val;
   }

   int top() {
      int val = stq.peek();
      return Math.max(val, mini);
   }

   int getMin() {
      return mini;
   }
}