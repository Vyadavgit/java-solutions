package Q19RemoveNthNodeFromEndOfList;

public class ListNode {
    static Node head;
    static Node tail;

    public ListNode(){}

    public void insert(int val){
        if(head == null){
            head = new Node(val);
            tail = head;
        }else {
            Node temp = new Node(val);
            tail.next = temp;
            tail = tail.next;
        }
    }

    public void printNodeList(){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.val);
            curr = curr.next;
            if (curr != null){
                System.out.print("->");
            }else {
                System.out.println();
            }
        }
    }

    public static void reverse(){
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public Node remove_nth_node_from_last(int n){
        if(head == null){
            return head;
        }

        reverse();
        Node curr = head;
        Node prev = null;

        while(n > 1){
            if(curr == null){
                // rereverse and return as it is
                reverse();
                return head;
            }
            prev = curr;
            curr = curr.next;
            n--;
        }

        if(prev ==  null){
            curr = curr.next;
            head = curr;
            reverse();
        }else {
            prev.next = curr.next;
            curr = curr.next;
            reverse();
        }
        return head;
    }

}
