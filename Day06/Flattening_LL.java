package Day06;
import Day05.ListNode;

/*    TC : O(n), SC : O(1)

Since each node has a bottom and next reference and is sorted. The main aim is to make a singly linked
list in sorted order of all nodes.
    . So we think of merge sort. We recurse to the last vertical list of nodes, after that we merge the lists.
    . Create a node temp. Assign a reference, res on temp. res is to keep track of temp and temp moves ahead
    as we build the flattened list.
    . The smaller node of the two is set to temp's bottom, then we move both temp and the chosen node.
    . If there are items left, then simply add to temp's bottom as they are sorted. Return flattened list.
 */
class Flattening_LL {
   ListNode merge(ListNode h1, ListNode h2) {
      ListNode temp = new ListNode(0), res = temp;

      while (h1 != null && h2 != null) {
         if (h1.val < h2.val) {
            temp.bottom = h1;
            temp = temp.bottom;
            h1 = h1.bottom;
         } else {
            temp.bottom = h2;
            temp = temp.bottom;
            h2 = h2.bottom;
         }
      }
      if (h1 != null) temp.bottom = h1;
      if (h2 != null) temp.bottom = h2;

      return res.bottom;
   }

   ListNode flatten(ListNode head) {
      if (head == null || head.next == null) return head;
      head.next = flatten(head.next);
      head = merge(head, head.next);
      return head;
   }
}