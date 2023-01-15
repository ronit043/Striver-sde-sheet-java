package Day06;
import Day05.ListNode;

/*       TC : O(n), SC : O(1)
Start traversing using two references (slow and fast). Here, the slow moves 1 step and the fast moves 2
steps. If both references meet at some node then it means a cycle is present. After that, move slow and head
by 1 step till both meet at a common node. This common node will be the starting node of the cycle.
 */

class Linked_List_Cycle_II {
   public ListNode detectCycle(ListNode head) {
      ListNode slow = head, fast = head;

      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
         if (slow == fast) break;
      }
      if (fast == null || fast.next == null) return null;
      while (head != slow) {
         head = head.next;
         slow = slow.next;
      }

      return head;
   }
}