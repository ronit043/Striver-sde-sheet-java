package Day13;
import java.util.ArrayDeque;
import java.util.Deque;

/*       TC: O(n), SC: O(n); n is the length of the given array
Initialise an array ngr of length N to store the next greater number of A[i] at index i. Create a stack of
type integer, where we will store the smaller item at the top. Traverse the array from backwards, because
when we'll Aive at a certain index its next greater item will be already in the stack, and we can
easily get this item. In the iteration:

1. We will pop the items from the stack till we get the larger item on top of the stack from the
current item and that item will be the answer for the current item.
2. If the stack gets empty while doing the pop operation then the answer would be -1. Store the next
greater item in the array.
3. Push the current item of the array into the stack.

Return the ngr array
 */
class Next_greater_element {
   public int[] nextGreater(int[] A, int n) {
      int[] ngr = new int[n];
      Deque<Integer> stq = new ArrayDeque<>();

      for (int i = n - 1; i >= 0; i--) {
         while (!stq.isEmpty() && A[i] >= stq.peek()) stq.pop();
         ngr[i] = stq.isEmpty() ? -1 : stq.peek();
         stq.push(A[i]);
      }

      return ngr;
   }
}
