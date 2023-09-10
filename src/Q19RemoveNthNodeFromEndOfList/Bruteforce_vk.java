package Q19RemoveNthNodeFromEndOfList;

public class Bruteforce_vk {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.insert(1);
        listNode.insert(2);
        listNode.insert(3);
        listNode.insert(4);
        listNode.insert(5);

        listNode.printNodeList();
        listNode.remove_nth_node_from_last(2);
        listNode.printNodeList();

    }


}
