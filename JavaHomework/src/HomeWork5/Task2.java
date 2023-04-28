package HomeWork5;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ivan Иванов");
        list.add("Svetlana Петрова");
        list.add("Kristina Белова");
        list.add("Anna Мусина");
        list.add("Anna Крутова");
        list.add("Ivan Юрин");
        list.add("Petr Лыков");
        list.add("Pavel Чернов");
        list.add("Petr Чернышов");
        list.add("Mary Федорова");
        list.add("Marina Светлова");
        list.add("Mary Савина");
        list.add("Mary Рыкова");
        list.add("Marina Лугова");
        list.add("Anna Владимирова");
        list.add("Ivan Мечников");
        list.add("Petr Петин");
        list.add("Ivan Ежов");

        showNames(list);

    }

    static Map<Integer,List<String>> getMap(List<String> list){
        Map<Integer,List<String>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            String[] fi = list.get(i).split(" ");
            if (isName(map,fi[0])){
                int key = getKey(map,fi[0]);
                map.get(key).remove(fi[0]);
                if (map.containsKey(++key)){
                    map.get(key).add(fi[0]);
                } else {
                    List<String> names = new ArrayList<>();
                    names.add(fi[0]);
                    map.put(key, names);
                }
            } else {
                if(map.isEmpty()){
                    List<String> names = new ArrayList<>();
                    names.add(fi[0]);
                    map.put(1, names);
                } else {
                    map.get(1).add(fi[0]);
                }
            }
        }
        return map;
    }

    static boolean isName (Map<Integer,List<String>> map, String name){
        for(int x: map.keySet()){
            if(map.get(x).contains(name)){
                return true;
            }
        }
        return false;
    }

    static int getKey (Map<Integer,List<String>> map, String name){
        for (Map.Entry<Integer,List<String>> entry: map.entrySet()){
            if (entry.getValue().contains(name)){
                return entry.getKey();
            }
        }
        return 0;
    }

    static void showNames(List<String> list){
        Map<Integer,List<String>> map = getMap(list);
        for (Map.Entry<Integer,List<String>> entry: map.entrySet()){
            if(entry.getKey() > 1)
                System.out.println(entry.getValue().toString() + " repeat " +
                        entry.getKey() + " times\n");
        }
    }
}
