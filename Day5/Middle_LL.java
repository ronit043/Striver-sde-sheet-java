package Day5;

/*
    TC: O(n)
    SC: O(1)

    The reason for while loop statement because when the fast pointer reaches to the end of the linked list,
    it can either be the last node (if number of nodes are even) or a last second node  (if number of nodes are odd).

    Slow pointer moves by one step and fast pointer moves by 2 steps
    slow pointer moved at half the speed of fast and thus,
    slow pointer must have traversed N/2 nodes and is currently at the middle node
*/

public class Middle_LL {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}