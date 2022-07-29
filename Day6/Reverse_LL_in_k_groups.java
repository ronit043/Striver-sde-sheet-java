package Day6;

import Day5.ListNode;

/* TC : O(n), SC : O(1)

Create a dummy node. Point it's next to head. Get the length of the list. Use 3 pointer pre, curr and nex
to reverse each group. On observation, we can see that we have to reverse each group, apart from
modifying links. Iterate through the linked list until the length of list >= k. Start nested iteration
for length of k. For each iteration modify links
    curr.next = nex.next;
    nex.next = pre.next;
    pre.next = nex;
    nex = curr.next;
Move pre to curr and reduce length by k.
 */
public class Reverse_LL_in_k_groups {
   ListNode reverseKGroup(ListNode head, int k) {
      ListNode dummy = new ListNode(0), pre = dummy, len = head;
      dummy.next = head;
      int size = 1;
      for (; len.next != null; size++) len = len.next;

      for (int i = 0; i < size / k; i++) {
         for (int j = 1; j < k; j++) {
            ListNode temp = pre.next;
            pre.next = head.next;
            head.next = head.next.next;
            pre.next.next = temp;
         }
         pre = head;
         head = head.next;
      }

      return dummy.next;
   }
}