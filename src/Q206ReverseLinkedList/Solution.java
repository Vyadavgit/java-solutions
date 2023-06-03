package Q206ReverseLinkedList;
// in place reversal of linked list
// asked by google, microsoft, apple, amazon
// Q.206. Reverse Linked List
// Given the head of a singly linked list, reverse the list, and return the reversed list.
//    Input: head = [1,2,3,4,5]
//    Output: [5,4,3,2,1]

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
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}