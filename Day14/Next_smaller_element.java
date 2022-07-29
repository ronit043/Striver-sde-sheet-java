package Day14;
import java.util.ArrayDeque;
import java.util.Deque;
/*       TC: O(n), SC: O(n); n is the length of the given array
Initialise an array nsl of length N to store the next smaller number of arr[i] at index i. Create a stack of
type integer, where we will store the greater element at the top. Traverse the array, when we arrive at
a certain index its next smaller element will be already in the stack, and we can easily get this item.
In the iteration:

1. We will pop the elements from the stack till we get the greater element on top of the stack from the
current element and that element will be the answer for the current element.

2. If the stack gets empty while doing the pop operation then the answer would be -1. Store the next
smaller element in the array.

3. Push the current element of the array into the stack.

Return nsl array
 */
public class Next_smaller_element {
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