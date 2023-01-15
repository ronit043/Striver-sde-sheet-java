package Day07;
import Day05.ListNode;

/*    TC : O(n), SC : O(1)

What we need to do is, find k-th element from start, cut list in two parts and put second part after the
first one. Steps:

. Find size, length of list, assign it to 1. Move slow to last node.
. Link slow to head, converting it to a circular linked list.
. Find item to cut our list from, it's index: size - (k % size). We do k % size, to make k come in range
of 0 to size. We subtract (k % size) from size, to reach kth node from start. Move slow to it's next.
. Finally, put head as slow.next, and remove link between slow and its next, return head.
*/
class Rotate_LL {
   public ListNode rotateRight(ListNode head, int k) {
      if (head == null || head.next == null || k == 0) return head;
      ListNode curr = head;
      int size = 1;

      for (; curr.next != null; size++) curr = curr.next;
      curr.next = head;
      for (int i = size - (k % size); i > 0; i--) curr = curr.next;
      head = curr.next;
      curr.next = null;

      return head;
   }
}