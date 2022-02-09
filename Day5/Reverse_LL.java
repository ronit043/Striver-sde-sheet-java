package Day5;

public class Reverse_LL {
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
}