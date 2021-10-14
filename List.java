import java.util.ArrayList;
import java.util.LinkedList;

public class List {
    public static void main(String[] args) {
        //ArrayList of integers
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(4);
        arrayList.add(7);
        arrayList.add(2);
        arrayList.add(6);
        arrayList.add(11);
        arrayList.add(2);
        java.util.List<Integer> t = arrayList.subList(1, 3);
        System.out.println(t);
        System.out.println(arrayList);
        System.out.println();

        // LinkedList of integers
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(4);
        linkedList.add(11);
        linkedList.add(2);
        System.out.println(linkedList);

    }
}
