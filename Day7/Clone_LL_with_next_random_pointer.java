package Day7;

import Day5.ListNode;

public class Clone_LL_with_next_random_pointer {
    public ListNode copyRandomList(ListNode head) {
        if(head == null) return head;
        
        // Step 1, create copies and changing references        
        for(ListNode iter = head; iter != null; iter = iter.next.next) {
            ListNode curr = new ListNode(iter.val);
            curr.next = iter.next;
            iter.next = curr;
        }
        
        // Step 2, assigning random references
        for(ListNode iter = head; iter != null; iter = iter.next.next) {
            if(iter.random != null) iter.next.random = iter.random.next;
        }
        
        // Step 3, rearranging references
        ListNode temp = new ListNode(0), copy = temp, front = head.next.next;
        temp.next = head.next;
        for(ListNode iter = head; iter != null;) {
            if(front != null) iter.next.next = front.next;
            iter.next = front;
            iter = front;
            if(front != null) front = front.next.next;
            copy = copy.next;
        }
        return temp.next;
    }
}