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

        Set<NoteBook> set = filterNoteBooks(noteBooks);
        System.out.println("Filtered notebooks: ");
        for(NoteBook noteBook: set)
            System.out.println(noteBook);
    }

    private static Map<Integer,String> getFilters(Set<NoteBook> set){
        String menu = "Enter number, соответствующую необходимому критерию\n" +
                "1 - RAM\n" +
                "2 - HDD\n" +
                "3 - OS\n" +
                "4 - Color\n" +
                "5 - Exit";
        Map<Integer,String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
            System.out.println(menu);
            int filter = scanner.nextInt();
            scanner.nextLine();
            do {
                if (filter <= 5 && filter > 0){
                    map.put(filter, "");
                    System.out.println(menu);
                    filter = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Incorrect input");
                    System.out.println(menu);
                    filter = scanner.nextInt();
                    scanner.nextLine();
                }
            } while (filter != 5);

//        for(Map.Entry<Integer,String> el: map.entrySet()){
//            System.out.println(el.getKey() + " " + el.getValue());
//        }
        return map;

    }

    private static Map<Integer,String> getMinValues(Map<Integer,String> map){
        System.out.println("Enter (min) value for research");
        Scanner scanner = new Scanner(System.in);
        for (Map.Entry<Integer, String> x: map.entrySet()){
            System.out.print(x + " ");
            if (scanner.hasNext())
                x.setValue(scanner.nextLine());
        }
//        for(Map.Entry<Integer,String> el: map.entrySet()){
//            System.out.println(el.getKey() + " " + el.getValue());
//        }
        return map;
    }

    static Set<NoteBook> filterNoteBooks (Set<NoteBook> set){
        Map<Integer,String> map = getMinValues(getFilters(set));
        Set<NoteBook> filterSet = new HashSet<>();
        boolean condition = false;
        for (NoteBook noteBook: set){
            for (Map.Entry<Integer, String> el: map.entrySet()){
                switch (el.getKey()){
                    case 1: condition = Integer.parseInt(el.getValue()) <= noteBook.getRam(); break;
                    case 2: condition = Integer.parseInt(el.getValue()) <= noteBook.getHdd(); break;
                    case 3: condition = el.getValue().equals(noteBook.getOs()); break;
                    case 4: condition = el.getValue().equals(noteBook.getColor());
                }
                if (!condition) break;
            }
            if (condition) {
                filterSet.add(noteBook);
            }
        }
        return filterSet;
    }
}
