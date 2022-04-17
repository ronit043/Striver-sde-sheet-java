package Day6;

import Day5.ListNode;

/*
    TC : O(n), 2 pass solution
    SC : O(1)

    Solution

    First find the middle of the linkedlist, then reverse the list after slow's next, reversing the list will
    enable us to compare values, since it's only a singly linked list. If we find a mismatch it's not a palindrome
    else it is.
*/

public class Palindrome_LL {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        // finding middle
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // changing slow's next reference to reverse of slow's next
        // moving slow to it's next position
        slow.next = reverseLL(slow.next);
        slow = slow.next;
        
        
        // checking head and middle values
        while(slow != null) {
            if(slow.val != head.val) return false;
            slow = slow.next;
            head = head.next;
        }
        return true; 
    }

    public ListNode reverseLL(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}