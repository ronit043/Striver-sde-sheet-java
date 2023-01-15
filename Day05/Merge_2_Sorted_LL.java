package Day05;

/*  TC: O(n + m), SC: O(1)

If any node is null, return the other one. Make a head node(add -1) and point temp to it.
On finding the smaller value
    Assign that node to temp's next and move node.
    Move temp as well.

If there are items left, add it to temp.
Return head's next.
*/

class Merge_2_Sorted_LL {
   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) return l2;
      if (l2 == null) return l1;
      ListNode head = new ListNode(-1), temp = head;

      while (l1 != null && l2 != null) {
         if (l1.val < l2.val) {
            temp.next = l1;
            l1 = l1.next;
         } else {
            temp.next = l2;
            l2 = l2.next;
         }
         temp = temp.next;
      }
      if (l1 != null) temp.next = l1;
      if (l2 != null) temp.next = l2;

      return head.next;
   }
}