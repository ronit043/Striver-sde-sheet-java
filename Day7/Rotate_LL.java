package Day7;

import Day5.ListNode;

/*
    TC : O(n)
    SC : O(1)

    What we need to do in this problem is to find k-th element from the end, cut list in two parts
    and put second part after the first one. Steps:

    Find n, length of our list.
    Find element where we need to cut our list: it has number size - (k % size), but we need to cut previous
    connection, so we stop one element earlier.
    Finally, put new head as slow.next, make connection between head and fast of original list and remove connection
    between slow and its next, return new head.
*/

public class Rotate_LL {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int size = 1; // since we are already at head node
        ListNode fast = head, slow = head;

        while (fast.next != null) {
            size++;
            fast = fast.next;
        }

        for (int i = size - k % size; i > 1; i--) slow = slow.next;

        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }
}