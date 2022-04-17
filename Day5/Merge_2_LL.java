package Day5;

/*
    TC: O(N)
    SC: O(1)
*/

public class Merge_2_LL {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // If any node is empty, return the other
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Create a new dummy node, and assign temp to it
        ListNode dummy = new ListNode(-1), temp = dummy;

        // The algo is similar to merge sort
        while (list1 != null && list2 != null) {
            // On finding the smaller value, assign that node to temp's next and move node
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move temp
            temp = temp.next;
        }

        // If any list still has elements then add it to temp
        if (list1 != null) temp.next = list1;
        if (list2 != null) temp.next = list2;

        return dummy.next;
    }
}