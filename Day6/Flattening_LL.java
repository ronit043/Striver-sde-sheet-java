public class Flattening_LL {
    ListNode merge(ListNode h1, ListNode h2) {
        ListNode temp = new ListNode(0), res = temp;
        while (h1 != null && h2 != null) {
            if(h1.val < h2.val) {
                temp.bottom = h1;
                temp = temp.bottom;
                h1 = h1.bottom;
            }
            else {
                temp.bottom = h2;
                temp = temp.bottom;
                h2 = h2.bottom;
            }
        }
        if(h1 != null) temp.bottom = h1;
        else temp.bottom = h2;
        return res.bottom;
    }
    ListNode flatten(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = flatten(head.next);
        head = merge(head, head.next);
        return head;
    }
}

class ListNode {
	int val;
	ListNode next, bottom;
	ListNode(int d) { val = d; }
}