package Q23MergekSortedLists;

public class ListN {
    Noden head;
    private Noden tail;
    private int size;

    public ListN(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Noden Noden = new Noden(val);
        Noden.next = head;
        head = Noden;

        if(tail == null){
            tail = head;
        }
        size +=1;
    }

    public void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Noden Noden = new Noden(val);
        tail.next = Noden;
        tail = Noden;
        size++;
    }
}
