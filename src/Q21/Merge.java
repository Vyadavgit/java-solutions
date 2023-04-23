package Q21;

public class Merge {
    public static void main(String[] args) {
        LL first = new LL();
        first.insertLast(1);
        first.insertLast(2);
        first.insertLast(4);

        LL second = new LL();
        second.insertLast(1);
        second.insertLast(3);
        second.insertLast(4);

        LL ans = merge(first, second);
        printLL(ans);

    }

    public static LL merge(LL first, LL second){
        Node f = first.head;
        Node s = second.head;

        LL ans = new LL();

        while (f != null && s != null){
            if(f.value < s.value){
                ans.insertLast(f.value);
                f = f.next;
            }else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null){
            ans.insertLast(f.value);
            f = f.next;
        }

        while (s != null){
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }

    public static void printLL(LL l){
        if(l.head == null){
            System.out.print(" ");
            return;
        }

        while (l.head != null){
            System.out.print(l.head.value + " ");
            l.head = l.head.next;
        }
    }

}
