package Q23MergekSortedLists;

public class Noden {
    int val;

    Noden next;

    public Noden(int value) {
        this.val = value;
    }

    public Noden(int value, Noden next) {
        this.val = value;
        this.next = next;
    }

    public Noden() {

    }
}
