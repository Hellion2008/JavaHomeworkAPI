package HomeWork6;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Set<NoteBook> noteBooks = new HashSet<>();
        noteBooks.add(new NoteBook(4,1024, "Windows", "Grey"));
        noteBooks.add(new NoteBook(8,2048, "MacOS", "Red"));
        noteBooks.add(new NoteBook(4,1024, "Linux", "Blue"));
        noteBooks.add(new NoteBook(16,2048, "Windows", "Grey"));
        noteBooks.add(new NoteBook(16,512, "MacOS", "Black"));
        noteBooks.add(new NoteBook(4,1024, "Linux", "Black"));
        noteBooks.add(new NoteBook(8,1024, "Windows", "Grey"));
        noteBooks.add(new NoteBook(4,512, "MacOS", "Green"));

//        for(NoteBook noteBook: noteBooks)
//            System.out.println(noteBook);

        getMinValues(getFilters(noteBooks));
//        filterNoteBooks(noteBooks);
    }

    static Map<Integer,String> getFilters(Set<NoteBook> set){
        String menu = "Введите цифру, соответствующую необходимому критерию\n" +
                "1 - ОЗУ\n" +
                "2 - Объем ЖД\n" +
                "3 - Операционная система\n" +
                "4 - Цвет\n" +
                "5 - Выход\n";
        Map<Integer,String> map = new HashMap<>();
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println(menu);
            int filter = scanner.nextInt();
            scanner.nextLine();
            do {
                map.put(filter, "");
                System.out.println(menu);
                filter = scanner.nextInt();
                scanner.nextLine();
            } while (filter != 5);
        }

//        for(Map.Entry<Integer,String> el: map.entrySet()){
//            System.out.println(el.getKey() + " " + el.getValue());
//        }
        return map;

    }

    static Map<Integer,String> getMinValues(Map<Integer,String> map){
        System.out.println("Задайте (минимальное) значение для поиска\n");
        try(Scanner scanner = new Scanner(System.in)){
            for (Integer x: map.keySet()){
                String tmp = scanner.nextLine();
                map.replace(x,tmp);
            }
        }
        for(Map.Entry<Integer,String> el: map.entrySet()){
            System.out.println(el.getKey() + " " + el.getValue());
        }
        return map;
    }
}
