package HomeWork3;

import java.util.Collections;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = Task1.createList(10, 0, 50);
        System.out.println(list);
        System.out.println("Max value: " + Collections.max(list));
        System.out.println("Min value: " + Collections.min(list));
        double average = 0;
        for (int x: list) {
            average += x;
        }
        System.out.println("Average value: " + average / list.size());
    }
}
