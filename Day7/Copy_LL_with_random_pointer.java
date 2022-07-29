package Day7;

import Day5.ListNode;

/*
        TC : O(n), SC : O(1)
Iterate the list and at each iteration create a copy "curr" (except random) of each node and set it's next to
original nodes next. Also insert it next to the original node.

Again iterate the list and copy the old node's random pointer (if exists) to the new node's random pointer:
node.next.random = node.random.next.

Create ans node to copy the new nodes from the old list using copy node along with restoring the old list.

Finally, return ans.next as ans currently refers to a dummy node.
 */
public class Copy_LL_with_random_pointer {
   public ListNode copyRandomList(ListNode head) {
      if (head == null) return head;

      for (ListNode iter = head; iter != null; iter = iter.next.next) {
         ListNode curr = new ListNode(iter.val);
         curr.next = iter.next;
         iter.next = curr;
      }

      for (ListNode iter = head; iter != null; iter = iter.next.next) {
         if (iter.random != null) iter.next.random = iter.random.next;
      }

      ListNode ans = new ListNode(0), copy = ans;
      while (head != null) {
         // Copy the alternate added nodes from the old linked list
         copy.next = head.next;
         copy = copy.next;

         // Restoring the old linked list, by removing the alternative newly added nodes
         head.next = head.next.next;
         head = head.next; // go to next alternate node
      }

      return ans.next;
   }
}