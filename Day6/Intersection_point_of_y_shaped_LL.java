package Day6;

import Day5.ListNode;

public class Intersection_point_of_y_shaped_LL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode a = headA, b = headB;

        // While both nodes aren't same move them
        while (a != b) {
            // If any node is null move to the next list else move the current list
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;
        }

        return a;
    }
}