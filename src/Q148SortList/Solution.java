package Q148SortList;
// Q148. Sort List
// Given the head of a linked list, return the list after sorting it in ascending order.
// Example 1:
//Input: head = [4,2,1,3]
//        Output: [1,2,3,4]

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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    public ListNode getMid(ListNode node){
        ListNode prev = null;
        while(node != null && node.next != null){
            prev = (prev == null) ? node : prev.next;
            node = node.next.next;
        }
        ListNode mid = prev.next;
        prev.next = null; // break
        return mid;
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                tail = tail.next;
                list1 = list1.next;
            }else{
                tail.next = list2;
                tail = tail.next;
                list2 = list2.next;
            }
        }

        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }
}