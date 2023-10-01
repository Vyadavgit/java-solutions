package Q23MergekSortedLists;

/*
23. Merge k Sorted Lists
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Time Complexity: O(k * n * log k)
Space Complexity: O(log k) the depth of the recursion is O(log k)
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    // log(N) along with O(k) calls to merge with a cost of O(n)
    private ListNode mergeKListsHelper(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }

        if(start + 1 == end){
            return merge(lists[start], lists[end]);
        }

        int mid  = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid+1, end);
        return merge(left, right);
    }


    // O(N)
    private ListNode merge(ListNode list1, ListNode list2){
        ListNode temp = new ListNode();
        ListNode head = temp;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        temp.next = (list1 != null) ? list1 : list2;

        return head.next;

    }
}