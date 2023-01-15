package Day05;

/*    TC: O(n), SC: O(1)

We use 2 extra references prev(equals null), and next. We iterate over the list till head != null, then
    Initialise next to head.next
    Link head.next to prev (reversing the list), and then prev will take the current value of head
    Update head with the value in next.
    
After the loop, we return prev.
 */
class Reverse_LL {
   public ListNode reverseList(ListNode head) {
      ListNode prev = null;

      while (head != null) {
         ListNode next = head.next;
         head.next = prev;
         prev = head;
         head = next;
      }

      return prev;
   }
}