package Q148SortList;

public class TestSolution extends LL{
    // using merge sort
    public Node sortList(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node mid = getMid(head);
        Node left = sortList(head);
        Node right = sortList(mid);

        return merge(left, right);
    }

    Node merge(Node list1, Node list2){
        Node dummyHead = new Node();
        Node tail = dummyHead;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    Node getMid(Node head){
        Node midPrev = null;
        while (head != null && head.next != null){
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null; //
        return mid;
    }

    public static void main(String[] args) {
        TestSolution list = new TestSolution();
        list.insertFirst(5);
        list.insertFirst(4);
        list.insertFirst(8);
        list.insertFirst(2);
        list.insertFirst(10);
        list.insertLast(7);
        list.display();
        System.out.println();
        Node res = list.sortList(list.getHead());
        list.display(res);
    }

}
