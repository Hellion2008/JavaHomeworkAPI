package HomeWork4;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        LinkedList<Integer> list = createList(10, 0, 50);
        System.out.println(list);
        System.out.println(reversedList(list));
    }

    static LinkedList<Integer> createList(int capacity, int min, int max){
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            list.add(random.nextInt(min, max));
        }
        return list;
    }

    static LinkedList<Integer> reversedList(LinkedList<Integer> list){
        LinkedList<Integer> changedList = new LinkedList<>();
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()){
            changedList.add(listIterator.previous());
        }
        return changedList;
    }
}
