package Day5;
/*
(Two-Pointer, One-Pass), TC: O(n), SC: O(1)

Let's assign two references - fast and slow to head. We will first iterate for n nodes from start using fast.

Now, between the references, there is a gap of n nodes. Now, just iterate and increment both the references
till fast reaches last node. The gap b/w references is still of n nodes, meaning that slow is nth node from
the last node (which currently is fast).

We just delete the next node to slow and return the head.
 */

public class Remove_nth_node_from_end_LL {
   public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode fast = head, slow = head;

      while (fast != null && n-- > 0) fast = fast.next;
      if (fast == null) return head.next;
      while (fast.next != null) {
         fast = fast.next;
         slow = slow.next;
      }
      slow.next = slow.next.next;

      return head;
   }
}