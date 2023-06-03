package Q148SortList;

import java.util.List;

public class LL {
    private Node head;
    private Node tail;

    public LL(){
    }

    public LL(Node head, Node tail){
        this.head = head;
        this.tail = tail;
    }

    public Node getHead(){
        return this.head;
    }

    public Node getTail(){
        return this.tail;
    }

    public Node insertFirst(int val){
        Node node = new Node(val);

        if(head == null){
            head = node;
            tail = head;
            return head;
        }

        node.next = head;
        head = node;

        return head;
    }

    public Node insertLast(int val){
        Node node = new Node(val);
        if(head == null){
            return insertFirst(val);
        }

        Node curr = head;
        Node prev = null;
        while (curr != null){
            prev = curr;
            curr = curr.next;
        }

        prev.next = node;
        tail = node;
        return head;
    }

    public void display(){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.val);
            if(curr.next != null){
                System.out.print("->");
            }
            curr = curr.next;
        }
    }

    public void display(Node node){
        Node curr = node;
        while (curr != null){
            System.out.print(curr.val);
            if(curr.next != null){
                System.out.print("->");
            }
            curr = curr.next;
        }
    }
}
