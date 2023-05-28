package Q143ReorderList;
// Q143. Reorder List
// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.
// Example 1:
//    Input: head = [1,2,3,4]
//    Output: [1,4,2,3]

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

    public Node deleteDuplicates() {
        Node curr = head;

        while(curr != null){
            if(curr.next != null && curr.val == curr.next.val){
                Node temp = curr.next;
                while(temp != null && curr.val == temp.val){
                    temp = temp.next;
                    size--;
                }
                curr.next = temp;
            }
            curr = curr.next;
        }

        return head;
    }

    public Node reverseBetween(Node head, int left , int right){
        if(left == right){
            return head;
        }

        // skip the first left-1 nodes
        Node curr = head;
        Node prev = null;
        for(int i = 2; curr != null && i <= left; i++){
            prev = curr;
            curr = curr.next;
        }

        Node last = prev;
        Node newEnd = curr;

        Node hold = curr.next;
        for(int i = 0; curr != null && i < right - left + 1; i++){
            curr.next = prev;
            prev = curr;
            curr = hold;

            if(hold != null){
                hold = hold.next;
            }
        }

        if(last != null){
            last.next = prev;
        }else {
            head = prev;
        }

        newEnd.next = curr;

        return head;
    }

    /**
     * Definition for singly-linked list.
     * public class Node {
     *     int val;
     *     Node next;
     *     Node() {}
     *     Node(int val) { this.val = val; }
     *     Node(int val, Node next) { this.val = val; this.next = next; }
     * }
     */
    public void reorderList() {
        if(head == null || head.next == null){
            return;
        }

        Node curr1 = head;
        Node middleNode = mid(head);
        Node curr2 = reverseList(middleNode.next);
        middleNode.next = null;

        while (curr1 != null && curr2 != null) {
            Node next1 = curr1.next;
            Node next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }
    }

    public Node mid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public Node reverseList(Node head){
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }


    public static void main(String[] args) {
        LL list = new LL();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
//        list.insertFirst(9);
//        list.insertLast(7);
//        list.insert(6,2);
//        list.insert(1, 3);
        list.display();

        list.reorderList();
        System.out.println();
        list.display();

//        list.reverseBetween(list.head, 2,4);
//        list.display();

//        System.out.println();
//        list.deleteFirst();
//        list.display();
//
//        System.out.println();
//        list.deleteLast();
//        list.display();
//        System.out.println("\nsize: "+list.size);
//
//        list.delete(2);
//        list.display();
//        System.out.println("\nsize: "+list.size);
//
//        list.delete(6);
//        list.display();
//        System.out.println("\nsize: "+list.size);


    }

}
