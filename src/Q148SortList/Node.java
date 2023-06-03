package Q148SortList;

public class Node {
    int val;
    Node next;

    public Node(){
    }

    public Node(int val){
        this.val = val;
        this.next = null;
    }

    public Node(int val, Node head){
        this.val = val;
        this.next = head;
    }

}
