package Day20;

public class Populate_next_right_pointers_of_tree {
    public Node connect(Node root) {
        Node head = root;

        for (; root != null; root = root.left) {
            for (Node cur = root; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                    if (cur.next != null) cur.right.next = cur.next.left;
                }
                else break;
            }
        }

        return head;
    }
}

class Node {
    public int val;
    public Node left, right, next;

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}