package HomeWork2;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
//        task0jewels();
        task1shuffleString();
    }

    static String findJewelsInStones(String jewels, String stones) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)){
                    count++;
                }
            }
            stringBuilder.append(String.valueOf(jewels.charAt(i)) + String.valueOf(count));
            count = 0;
        }
        return stringBuilder.toString();
    }

    static void task0jewels(){
        try(Scanner scanner = new Scanner(System.in)){
            String jewels = scanner.nextLine();
            String stones  = scanner.nextLine();
            System.out.println(findJewelsInStones(jewels, stones));
        }
    }

    static String shuffle(final String s, final int[] index) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            stringBuilder.append(s.charAt(index[i]));
        }
        return stringBuilder.toString();
    }

    static void task1shuffleString(){
        String s = "abcdefghij";
        int[] index = {2,1,0,4,5,8,7,9,3,6};
        System.out.println(shuffle(s,index));
    }

}
