package HomeWork4;


public class MyLinkedList {

    private Integer[] arr = new Integer[10];
    private int maxLength = 150;
    private int minlegth = 10;
    private int lastElement = 0;
    private int firstElement = 0;


    int size(){
        return lastElement - firstElement;
    }

    boolean empty(){
        return lastElement - firstElement == 0;
    }

    void enqueue(int element){
        if (lastElement - firstElement == arr.length){
            Integer[] arr2 = new Integer[arr.length + 10];
            System.arraycopy(arr, firstElement, arr2,0, arr.length);
            arr = arr2;
        }
        arr[lastElement++] = element;
    }

    Integer dequeue(){

        //если пустая коллекция
        if(firstElement == lastElement){
            System.out.println("List is empty");
            throw new ArrayIndexOutOfBoundsException();
        }

//        если длина массива превысила фиксированную длину fixLength
        if (arr.length > maxLength && lastElement - firstElement < minlegth){
            Integer[] arr2 = new Integer[lastElement - firstElement];
            System.arraycopy(arr, firstElement, arr2,0,lastElement - firstElement);
            arr = arr2;
            lastElement = lastElement - firstElement;
            firstElement = 0;
        }
        return arr[firstElement++];
    }

    Integer first(){
        return arr[0];
    }

    void showList(){
        for (int i = firstElement; i < lastElement; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
