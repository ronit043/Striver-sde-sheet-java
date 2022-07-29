package Day6;
/*
        TC : O(n), SC : O(1)
Using two references

If any of the list is null return null. Initialise two references a, b at the head of the two lists. Traverse
through the lists, one node at a time. When any reference reaches null redirect it to the head of the other list.
Once both of them go through reassigning, they will be equidistant from the collision point. If two references meet at
a node, then it's the intersection node.
 */

import Day5.ListNode;

public class Intersection_point_of_y_shaped_LL {
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) return null;
      ListNode a = headA, b = headB;

      while (a != b) {
         a = (a == null) ? headB : a.next;
         b = (b == null) ? headA : b.next;
      }

      return a;
   }
}