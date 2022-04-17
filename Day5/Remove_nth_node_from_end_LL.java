package Day5;
/*
(Two-Pointer, One-Pass), TC: O(n), SC: O(1)

We are required to remove the nth node from the end of list. For this, we need to traverse N - n nodes from the
start of the list, where N is the length of linked list.
Let's assign two pointers - fast and slow to head. We will first iterate for n nodes from start using fast.

Now, between the fast and slow pointers, there is a gap of n nodes. Now, just Iterate and increment both the pointers
till fast reaches the last node. The gap between fast and slow is still of n nodes, meaning that slow is nth node from
the last node (which currently is fast).

We then delete the nth node from the end of the list.
 */

public class Remove_nth_node_from_end_LL {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;

        while (n-- > 0 && fast != null) fast = fast.next;
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}