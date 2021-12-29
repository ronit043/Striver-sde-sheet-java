/**
 * Palindrome_LL
 */
public class Palindrome_LL {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverse(slow.next);
        slow = slow.next;

        while(slow != null) {
            if(head.val == slow.val){
                slow = slow.next;
                head = head.next;
            }
            else return false;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
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

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}