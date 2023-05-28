package Q234PalindromeLinkedList;
// Q234. Palindrome Linked List
// LinkedIn, google, facebook, amazon, apple asked
// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
//  Example 1:
// Input: head = [1,2,2,1]
//  Output: true

// Time complexity: O(n)
// space complexity: constant cuz no extra space is needed

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
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode secondhead = reverseList(mid);

        while(head != null && secondhead != null){
            if(head.val != secondhead.val){
                break;
            }
            head = head.next;
            secondhead = secondhead.next;
        }

        return head == null || secondhead == null;
    }

    public ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head){
        if(head == null){
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;

            if(next != null){
                next = next.next;
            }
        }

        return prev;
    }

}