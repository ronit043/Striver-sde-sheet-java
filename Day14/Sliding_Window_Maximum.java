package Day14;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*       TC: O(n), SC: O(k)
The basic idea of this approach is to use a deque to store the indexes of the window. We will maintain a
deque that will store indexes in non-increasing order such that the maximum item of the window is at the
front of the deque. We will store the index of all items of the given array.

Start traversing the array from the front.

1. Remove the items from the back of the deque if it's smaller than incoming item, as there's no point
in storing them.
2. Insert the index of the current item at the end of the deque.
3. Remove the front item from the deque if its index lies outside the boundary of the current window
because the deque is used to store the index of the current window.
4. Get the maximum item of the current window which is at the front of the deque. Add the maximum
item of the current window in the list.

After the iteration is over, convert the list to array and return.
 */
class Sliding_Window_Maximum {
   public int[] maxSlidingWindow(int[] nums, int k) {
      Deque<Integer> adq = new ArrayDeque<>();
      List<Integer> al = new ArrayList<>();

      for (int i = 0; i < nums.length; i++) {
         while (!adq.isEmpty() && nums[i] >= nums[adq.peekLast()]) adq.pollLast();
         adq.addLast(i);
         if (!adq.isEmpty() && adq.peekFirst() == i - k) adq.pollFirst();
         if (i >= k - 1) al.add(nums[adq.peekFirst()]);
      }

      return al.stream().mapToInt(i -> i).toArray();
   }
}