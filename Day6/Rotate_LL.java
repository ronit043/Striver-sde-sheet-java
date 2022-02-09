package Day6;

import Day5.ListNode;

public class Rotate_LL {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int size = 1; // since we are already at head node
        ListNode fast = head, slow = head;

        while (fast.next != null) {
            size++;
            fast = fast.next;
        }
        // i>1 because we need to put slow.next at the start.
        for (int i = size - k % size; i > 1; i--) slow = slow.next;

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}