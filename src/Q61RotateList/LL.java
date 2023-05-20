package Q61RotateList;

// facebook, twitter, google asked
// Q61. Rotate List
// Given the head of a linked list, rotate the list to the right by k places.
// Example 1:
//    Input: head = [1,2,3,4,5], k = 2
//    Output: [4,5,1,2,3]
public class LL {
    private Node head;
    private Node tail;
    private int size;

    public LL(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    public void insertLast(int val){
        if(head == null){
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int index){

        if(index > size){
            return;
        }

        Node curr = head;

        if(index == 0){
            insertFirst(val);
            return;
        }

        while(index > 1){
            curr = curr.next;
            index--;
        }

        // if index == 1 is auto handled here
        Node hold = curr.next;
        Node node = new Node(val);
        curr.next = node;
        node.next = hold;
        size++;
    }

    public void deleteFirst(){
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
    }

    public void deleteLast(){
        if(head == tail){
            head = null;
            tail = null;
            size--;
        }

        Node curr = head;
        Node preTail = null;
        while (curr != tail){
            preTail = curr;
            curr = curr.next;
        }
        preTail.next = null;
        tail = preTail;
        size--;
    }

    public void delete(int index){
        if(index == 0){
            deleteFirst();
            return;
        }

        if(index == size-1){
            deleteLast();
            return;
        }

        Node curr = head;
        int i = 1;
        while (i != index){
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        size--;
    }

    public void display(){
        int listsize = size;
        Node curr = head;
        if(curr == null){
            System.out.println("The list if empty.");
        }

        while (listsize > 0){
            System.out.print(curr.val);
            if(listsize > 1){
                System.out.print("->");
            }
            curr = curr.next;
            listsize--;
        }
    }

    private class Node{
        private int val;
        private Node next;

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(7);
        list.insertFirst(2);
        list.insertFirst(0);
        list.insertFirst(9);
        list.insertFirst(3);
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(8);
        list.insertLast(7);
        list.insert(4, 3);
        list.insert(1, 1);
        list.display();

        System.out.println();
        list.deleteFirst();
        list.display();

        System.out.println();
        list.deleteLast();
        list.display();
        System.out.println("\nsize: "+list.size);

        list.delete(2);
        list.display();
        System.out.println("\nsize: "+list.size);

        list.delete(9);
        list.display();
        System.out.println("\nsize: "+list.size);


    }

    // solution
//    /**
//     * Definition for singly-linked list.
//     * public class ListNode {
//     *     int val;
//     *     ListNode next;
//     *     ListNode() {}
//     *     ListNode(int val) { this.val = val; }
//     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//     * }
//     */
//    class Solution {
//        public ListNode rotateRight(ListNode head, int k) {
//            ListNode curr = head;
//            int size = 0;
//
//            if(head != null){
//                size++;
//            }else{
//                return head;
//            }
//
//            while(curr.next != null){
//                curr = curr.next;
//                size++;
//            }
//            curr.next = head;
//
//            k = k % size;
//            while(size > k){
//                curr = curr.next;
//                size--;
//            }
//
//            head = curr.next;
//            curr.next = null;
//
//            return head;
//
//        }
//    }
}
