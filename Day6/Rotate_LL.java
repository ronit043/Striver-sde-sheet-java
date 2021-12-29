public class Rotate_LL {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            ++len;
            curr = curr.next;
        }

        curr.next = head;
        k = len - k % len;

        while (k-- > 0)
            curr = curr.next;
        head = curr.next;
        curr.next = null;

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}