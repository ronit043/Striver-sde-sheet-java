package Day5;

/*
    TC: O(max(N, M)) where N is length of l1 & M is length of l2
    SC: O(max(N, M))
 */

public class Add_2_numbers_LL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        // Creating a head node and adding -1, to it and assigning temp to head
        ListNode head = new ListNode(-1), temp = head;

        // While none of the list extinguish, or carry has non-zero value
        while(l1 != null || l2 != null || carry != 0) {
            // If any list is null add zero else the value of the node and carry
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            // For the next addition carry would be sum / 10
            carry = sum / 10;
            // The node value would be sum % 10
            ListNode newH = new ListNode(sum % 10);
            // Add newH to temp's next and move temp
            temp.next = newH;
            temp = newH;

            // If there are elements in the lists, then traverse
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        
        return head.next;
    }  
}