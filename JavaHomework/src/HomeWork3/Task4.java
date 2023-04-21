package HomeWork3;

public class Task4 {
    public static void main(String[] args) {
        int[] arr = {2,5,8,4,6,3,100,45,1,29,46,20,78};
        for (int x: sortMerge(arr))
            System.out.print(x + " ");
    }

    static int[] sortMerge(int[] arr){
        if (arr.length == 1) {
            return arr;
        }
        int[] left = new int[arr.length /2];
        for (int i = 0; i < arr.length / 2; i++) {
            left[i] = arr[i];
        }
        int a = arr.length - arr.length /2;
        int[] right = new int[a];
        for (int i = 0; i < a; i++) {
            right[i] = arr[arr.length /2+ i];
        }
        arr = mergeArray(sortMerge(left), sortMerge(right));
        return arr;
    }

    static int[] mergeArray(int[] left, int[] right) {
        int [] array = new int[left.length + right.length];
        int posLeft = 0, posRight = 0;

        for (int i = 0; i < array.length; i++) {
            if (posLeft > left.length - 1){
                array[i] = right[posRight];
                posRight++;
            }
            else if (posRight > right.length - 1){
                array[i] = left[posLeft];
                posLeft++;
            }
            else if (left[posLeft] < right[posRight]){
                array[i] = left[posLeft];
                posLeft++;
            }
            else {
                array[i] = right[posRight];
                posRight++;
            }
        }
        return array;
    }
}
