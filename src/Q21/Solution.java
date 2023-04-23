package Q21;

// Q21. Merge Two Sorted Lists
//    You are given the heads of two sorted linked lists list1 and list2.
//    Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
//    Return the head of the merged linked list.
//    Example 1:
//    Input: list1 = [1,2,4], list2 = [1,3,4]
//    Output: [1,1,2,3,4,4]

// Time complexity: O(m+n)
//Since we are traversing both lists once and performing a constant amount of work at each iteration, the time complexity of this part of the algorithm is O(m + n).

// leetcode submitted soln
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode ans = head;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ans.next = list1;
                list1 = list1.next;
            }else{
                ans.next = list2;
                list2 = list2.next;
            }
            ans = ans.next;
        }

        while(list1 != null){
            ans.next = list1;
            ans = ans.next;
            list1 = list1.next;
        }

        while(list2 != null){
            ans.next = list2;
            ans = ans.next;
            list2 = list2.next;
        }

        return head.next;
    }
}

