package Day14;
import java.util.ArrayDeque;
import java.util.Deque;
/*       TC: O(n), SC: O(n); n is the length of the given array
Initialise an array nsl of length N to store the next smaller number of arr[i] at index i. Create a stack of
type Integer, where we will store the greater item at the top. Traverse the array, when we arrive at
a certain index its next smaller item will be already in the stack, and we can easily get this item.
In the iteration:

1. We will pop the items from the stack till we get the smaller item on top of the stack from the
current item and that item will be the answer for the current item.
2. If the stack gets empty while doing the pop operation then the answer would be -1. Store the next
smaller item in the array.
3. Push the current item of the array into the stack.

Return nsl array
 */
class Next_smaller_element {
   public int[] prevSmaller(int[] A) {
      int[] nsl = new int[A.length];
      Deque<Integer> stq = new ArrayDeque<>();

      for (int i = 0; i < A.length; i++) {
         while (!stq.isEmpty() && A[i] <= stq.peek()) stq.pop();
         nsl[i] = stq.isEmpty() ? -1 : stq.peek();
         stq.push(A[i]);
      }

      return nsl;
   }
}