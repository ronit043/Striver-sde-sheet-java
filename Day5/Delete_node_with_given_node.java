package Day5;

public class Delete_node_with_given_node {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }   
}