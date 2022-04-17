package Day6;

import Day5.ListNode;

public class Reverse_LL_in_k_groups {
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

    // Method to reverse a linked list from head to tail
    ListNode reverse(ListNode head, ListNode tail) {
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