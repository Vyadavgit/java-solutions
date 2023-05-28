package Q92ReverseLinkedListII;
//Q92. Reverse Linked List II
// Google, Microsoft, Facebook asked
//    Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
//    Example 1:
//    Input: head = [1,2,3,4,5], left = 2, right = 4
//    Output: [1,4,3,2,5]

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;

        // skip first left - 1 nodes
        for(int i = 0; curr != null && i <= left-2; i++){
            prev = curr;
            curr = curr.next;
        }

        ListNode last = prev;
        ListNode newEnd = curr;

        ListNode hold = curr.next;
        for(int i = 0; curr != null && i < right - left + 1; i++){
            curr.next = prev;
            prev = curr;
            curr = hold;

            if(hold != null){
                hold = hold.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else{
            head = prev;
        }

        newEnd.next = curr;
        return head;
    }
}