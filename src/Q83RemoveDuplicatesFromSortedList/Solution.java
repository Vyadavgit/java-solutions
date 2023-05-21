package Q83RemoveDuplicatesFromSortedList;
// Q83. Remove Duplicates from Sorted List
//    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
// Example 1:
//    Input: head = [1,1,2]
//    Output: [1,2]
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                ListNode temp = curr.next;
                while(temp != null && curr.val == temp.val){
                    temp = temp.next;
                }
                curr.next = temp;
            }
            curr = curr.next;
        }
        return head;
    }
}

//    class Solution {
//        public ListNode deleteDuplicates(ListNode node) {
//            if(node == null){
//                return node;
//            }
//            ListNode head = node;
//            while(node.next != null){
//                if(node.val == node.next.val){
//                    node.next = node.next.next;
//                } else{
//                    node = node.next;
//                }
//            }
//            return head;
//        }
//    }