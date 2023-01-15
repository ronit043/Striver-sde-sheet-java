package Day06;
import Day05.ListNode;

/*    TC : O(n), SC : O(1)

Use 2 references: slow and fast (initialised both at head). Slow reference takes one step and fast reference
takes 2 steps. If there exists a cycle, both slow and fast will reach the exact same node. If there is no
cycle in the given linked list, then fast reference will reach the end of the linked list well before the
slow reference reaches the end or null.
 */
class Linked_List_Cycle_I {
   public boolean hasCycle(ListNode head) {
      ListNode slow = head, fast = head;

      while (fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
         if (slow == fast) return true;
      }

      return false;
   }
}