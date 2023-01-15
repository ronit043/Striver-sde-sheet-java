package Day06;
import Day05.ListNode;

/* TC : O(n), SC : O(1)

Create a dummy node. Point it's next to head. Get the length of the list. Use 3 pointer pre, curr and nex
to reverse each group. On observation, we can see that we have to reverse each group, apart from
modifying links. Iterate through the linked list until the length of list >= k. Start nested iteration
for length of k. For each iteration modify links
    curr.next = nex.next; nex.next = pre.next; pre.next = nex; nex = curr.next;
Move pre to curr and reduce length by k.
 */
class Reverse_LL_in_k_groups {
   public ListNode reverseKGroup(ListNode head, int k) {
      ListNode curr = head;
      for (int i = 0; i < k; i++) {
         if (curr == null) return head;
         curr = curr.next;
      }
      ListNode newH = reverse(head, curr);
      head.next = reverseKGroup(curr, k);
      return newH;
   }

   public ListNode reverse(ListNode head, ListNode tail) {
      ListNode prev = tail;
      while (head != tail) {
         ListNode next = head.next;
         head.next = prev;
         prev = head;
         head = next;
      }
      return prev;
   }
}