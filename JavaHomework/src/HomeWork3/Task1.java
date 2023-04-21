package HomeWork3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = createList(10, 0,50);
        System.out.println(list);
        changeList(list);

    }

    public static List<Integer> createList(int capacity, int min, int max){
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < capacity; i++) {
            list.add(random.nextInt(min, max));
        }
        return list;
    }

    static void changeList (List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0){
                list.remove(i);
                i--;
            }
        }
        System.out.println(list);
    }
}
