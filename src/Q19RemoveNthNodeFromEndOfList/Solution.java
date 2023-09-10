package Q19RemoveNthNodeFromEndOfList;

/*
Time Complexity: O(n)
Space Complexity: O(1)
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head; // fast and slow point to head

        // move fast to create a gap of n between fast and slow
        for(int i = 0; i < n; i++){
            fast  = fast.next;
        }
        if (fast == null) return head.next; // if the first element needs to be removed

        // now move both fast and slow until fast reaches the end
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next; // remove nth node

        return head;
    }
}