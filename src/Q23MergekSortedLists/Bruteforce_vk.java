package Q23MergekSortedLists;

// 15 / 133 testcases passed

/*
*
Time Complexity: O(k * n) in the worst case, where k is the number of linked lists
Space Complexity: O(n)
* */
public class Bruteforce_vk {
    public static void main(String[] args) {
        Noden[] nodes = new Noden[3];

        ListN list1 = new ListN();
//        list1.insertFirst(2);
        list1.insertFirst(5);
        list1.insertFirst(4);
        list1.insertFirst(1);

        ListN list2 = new ListN();
        list2.insertFirst(4);
        list2.insertFirst(3);
        list2.insertFirst(1);

        ListN list3 = new ListN();
//        list3.insertFirst(-1);
        list3.insertFirst(6);
        list3.insertFirst(2);

        nodes[0] = list1.head;
        nodes[1] = list2.head;
        nodes[2] = list3.head;

        display(nodes[0]);
        display(nodes[1]);
        display(nodes[2]);

        Noden ret = mergeKLists(nodes);

        display(ret);
    }

    public static void display(Noden ret){
        while(ret != null){
            System.out.print(ret.val);
            if (ret.next != null){
                System.out.print("->");
            }else {
                System.out.println();
            }
            ret = ret.next;
        }
    }

    public static Noden mergeKLists(Noden[] lists) {
        Noden tmp = new Noden();
        for(Noden list : lists){
            if(list != null){
                tmp = mergeTwoLists(tmp, list);
            }
        }

        return tmp;
    }


    public static Noden mergeTwoLists(Noden list1, Noden list2) {
        Noden head = new Noden();
        Noden ans = head;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ans.next = list1;
                list1 = list1.next;
            }else{
                ans.next = list2;
                list2 = list2.next;
            }
            ans = ans.next;
        }

        while(list1 != null){
            ans.next = list1;
            list1 = list1.next;
            ans = ans.next;
        }

        while(list2 != null){
            ans.next = list2;
            list2 = list2.next;
            ans = ans.next;
        }

        return head.next;
    }
}
