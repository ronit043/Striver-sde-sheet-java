package Day05;

/*    TC: O(n), SC: O(1)
Slow reference moves by one step and fast reference moves by 2 steps, slow moves at half the speed of fast
and thus, slow reference must have traversed N/2 nodes and is currently at the middle node.

The reason for while loop statement because when the fast reference reaches the end of the linked list,
it can either be the last node (if #nodes are even) or a second last node (if #nodes are odd).
*/

class Middle_LL {
   public ListNode middleNode(ListNode head) {
      ListNode fast = head, slow = head;

      while (fast != null && fast.next != null) {
         fast = fast.next.next;
         slow = slow.next;
      }

      return slow;
   }
}