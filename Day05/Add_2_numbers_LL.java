package Day05;

/*    TC: O(max(N, M)) where N is length of l1 & M is length of l2, SC: O(max(N, M))

Create a head (add -1), and assign temp to head. While none of the list finish, or carry has non-zero value:
    1. If any list is null add 0, else add the value of the node and carry to the sum variable.
    2. For the next addition carry would be sum / 10.
    3. The new node (newH) value would be sum % 10.
    4. Add newH to temp's next and move temp.
    5. If there are items in the lists, then traverse them.

Return head's next.
 */

class Add_2_numbers_LL {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int carry = 0;
      ListNode head = new ListNode(-1), temp = head;

      while (l1 != null || l2 != null || carry != 0) {
         int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
         carry = sum / 10;
         ListNode newH = new ListNode(sum % 10);
         temp.next = newH;
         temp = newH;

         if (l1 != null) l1 = l1.next;
         if (l2 != null) l2 = l2.next;
      }

      return head.next;
   }
}