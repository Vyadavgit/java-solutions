package Q61RotateList;
// Q61. Rotate List
// Given the head of a linked list, rotate the list to the right by k places.
// Example 1:
//    Input: head = [1,2,3,4,5], k = 2
//    Output: [4,5,1,2,3]
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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;
        int size = 0;

        if(head != null){
            size++;
        }else{
            return head;
        }

        while(curr.next != null){
            curr = curr.next;
            size++;
        }
        curr.next = head;

        k = k % size;
        while(size > k){
            curr = curr.next;
            size--;
        }

        head = curr.next;
        curr.next = null;

        return head;

    }
}