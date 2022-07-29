package Day6;

import Day5.ListNode;

/*
    TC : O(n), 2 pass solution, SC : O(1)

    First find the middle(or near middle) of the linked list, then reverse the list after slow's next,
    reversing the list will help to compare values easily, since it's a singly linked list. Move slow to it's
    next position. If we find a mismatch it's not a palindrome, else it is.
*/

public class Palindrome_LL {
   public boolean isPalindrome(ListNode head) {
      ListNode slow = head, fast = head;

      while (fast.next != null && fast.next.next != null) {
         slow = slow.next;
         fast = fast.next.next;
      }
      slow.next = reverseLL(slow.next);
      slow = slow.next;
      while (slow != null) {
         if (slow.val != head.val) return false;
         slow = slow.next;
         head = head.next;
      }

      return true;
   }

   public ListNode reverseLL(ListNode head) {
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