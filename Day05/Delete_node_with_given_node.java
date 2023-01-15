package Day05;

/* TC : O(1), SC : O(1)

We copy the value of the next node to the current node and after that we change links so that,
it points to the next of next node.
 */
class Delete_node_with_given_node {
   public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
   }
}