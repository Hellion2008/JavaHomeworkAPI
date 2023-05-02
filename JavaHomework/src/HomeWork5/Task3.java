package HomeWork5;

public class Task3 {
    public static void main(String[] args) {
        int[] array = {5, 56, 79, 2, 7, 23};
        sort(array);
        showArray(array);
    }

    static void sort (int[] arr){
        for (int i = arr.length / 2; i >= 0 ; i--) {
            heapify(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i >= 0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify (int[] arr, int n, int i){
        int highest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && arr[left] > arr[highest])
            highest = left;
        if (right < n && arr[right] > arr[highest])
            highest = right;
        if (highest != i){
            int temp = arr[i];
            arr[i] = arr[highest];
            arr[highest] = temp;
            heapify(arr, n, highest);
        }
    }

    static void showArray (int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
