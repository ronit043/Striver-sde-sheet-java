package Day5;

public class Delete_node_with_given_node {
    public void deleteNode(ListNode node) {
        // Copy the value of the next node to the current node
        node.val = node.next.val;
        // Re-assign the nodes
        node.next = node.next.next;
    }   
}