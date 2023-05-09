package Q25ReverseNodesInKGroup;

// 25. Reverse Nodes in k-Group
/*
* Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

You may not alter the values in the list's nodes, only nodes themselves may be changed.
* */
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode temp = null;
        ListNode newHead = null;
        ListNode prevTail = null;

        while(curr != null){
            int count = 0;
            ListNode tail = curr; // new tail

            while(count < k && tail != null){ // iterate till k and non null
                tail = tail.next;
                count++;
            }

            if(count == k){
                temp = reverse(curr, k); // reversed till k and returned new head of the reversed segment

                // only happens first time
                if(newHead == null){
                    newHead = temp; // new head assigned
                }

                // joins tail of last reversed list to head following reversed list
                if(prevTail != null){
                    prevTail.next = temp;
                }

                // if prevTail is null [only happens first time]
                prevTail = curr;
                curr = tail;

            }else{ // there aren't k nodes, join the the tail of recent reversed list to head of the unrrversed remaining list
                if(prevTail != null){
                    prevTail.next = curr;
                }
                break;
            }

        }

        return newHead == null ? head : newHead;

    }

    public ListNode reverse(ListNode head, int k){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(k>0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            k--;
        }
        return prev;
    }
}




