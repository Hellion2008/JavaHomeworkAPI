package HomeWork2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Program {
    public static void main(String[] args) throws IOException {
//        task0jewels();
//        task1shuffleString();
//        task2recipe();
        task3byte();
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

    static String[] fillArray (int n, Scanner sc){
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextLine();
        }
        return arr;
    }

    static void task2recipe(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter count of lines:");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] recipes = fillArray(n,scanner);
        System.out.println("Enter count of pruducts:");
        int m = scanner.nextInt();
        scanner.nextLine();
        String[] products = fillArray(m, scanner);
        for (int i = 0; i < recipes.length; i++) {
            for (int j = 0; j < products.length; j++) {
                String[] tempProduct = products[j].split(" - ");
                if (recipes[i].toLowerCase().contains(tempProduct[0])){
                    recipes[i] = recipes[i].replaceAll(tempProduct[0], tempProduct[1]);
                    recipes[i] = recipes[i].replaceAll(tempProduct[0].substring(0, 1).toUpperCase() + tempProduct[0].substring(1),
                            tempProduct[1].substring(0, 1).toUpperCase() + tempProduct[1].substring(1));
                }
            }
        }
        for (String line: recipes) {
            System.out.println(line);
        }

    }

    static void task3byte() throws IOException {
        try(Scanner scanner = new Scanner(System.in)){
            File result = new File("src\\HomeWork2\\result.txt");
            byte num = scanner.nextByte(); scanner.nextLine();
            FileWriter fileWriter = new FileWriter(result);
            fileWriter.write(Byte.toString(num));
            fileWriter.close();
        } catch (Exception ex){
            Logger logger = Logger.getLogger(Program.class.getName());
            ConsoleHandler consoleHandler = new ConsoleHandler();
            logger.addHandler(consoleHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            consoleHandler.setFormatter(simpleFormatter);
            logger.log(Level.WARNING, ex.getMessage());

        }
    }
}
