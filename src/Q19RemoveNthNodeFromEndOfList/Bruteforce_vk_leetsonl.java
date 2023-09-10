package Q19RemoveNthNodeFromEndOfList;

// Q19. Remove Nth Node From End of List
/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.
Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 */

/*
Time Complexity: O(n)
Space Complexity: O(n)
* */
public class Bruteforce_vk_leetsonl {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null){
            return head;
        }

        head = reverse(head);
        ListNode curr = head;
        ListNode prev = null;

        while(n > 1){
            if(curr == null){
                // rereverse and return as it is
                head = reverse(head);
                return head;
            }
            prev = curr;
            curr = curr.next;
            n--;
        }

        if(prev ==  null){
            curr = curr.next;
            head = curr;
        }else {
            prev.next = curr.next;
            curr = curr.next;
        }

        head = reverse(head);
        return head;
    }

    public static ListNode reverse(ListNode head){
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
