package HomeWork4;

public class Task2 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        for (int i = 0; i < 1000; i++) {
            list.enqueue(i);
        }

        System.out.println(list.size());
        System.out.println(list.first());
        System.out.println();

        list.showList();
        System.out.println();

        System.out.println(list.dequeue());
        System.out.println();
        System.out.println(list.dequeue());
        System.out.println();

        System.out.println("Start size: " + list.size());
        int currentSize = list.size();

        for (int i = 0; i < currentSize ; i++) {
            System.out.print(list.dequeue() + " ");
        }
        list.showList();
        System.out.println("Current size: " + list.size());

//        int a = list.dequeue();
//        System.out.println(a);

    }
}
