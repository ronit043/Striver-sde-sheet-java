public class Reverse_LL_in_groups_on_given_size_k {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = head;
        int c = 0;
        while (prev != null && c != k) {
            prev = prev.next;
            c++;
        }
        if (c == k) {
            prev = reverseKGroup(prev, k);
            while (c-- > 0) {
                ListNode next = head.next;
                head.next = prev;
                prev = head;
                head = next;
            }
            head = prev;
        }
        return head;
    } 
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}