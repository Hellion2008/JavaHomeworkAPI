package HomeWork4;

import java.util.LinkedList;
import java.util.ListIterator;

public class Task3 {
    public static void main(String[] args) {
        LinkedList<Integer> list = Task1.createList(3, 0, 50);
        System.out.println(list);
        System.out.println(sumList(list));
    }

    static int sumList(LinkedList<Integer> list){
        int sum = 0;
//        for (int x: list) {
//            sum += x;
//        }
        ListIterator<Integer> iterator = list.listIterator();
        while(iterator.hasNext()){
            sum += iterator.next();
        }
        return sum;
    }
}
