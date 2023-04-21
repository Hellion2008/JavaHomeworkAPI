package HomeWork2;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.*;

public class Program {
    public static void main(String[] args) throws IOException {
//        task0jewels();
//        task1shuffleString();
//        task2recipe();
//        task3byte();
//        task3url();
        task4calculator();
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

    static String download(String url) throws IOException {
        URL urlFile = new URL(url);
        InputStream input = urlFile.openStream();
        byte[] buffer = input.readAllBytes();
        return new String(buffer);
    }

    static String change(String name, String fileContent) {
        return String.format(fileContent, name);
    }

    static void saveOnLocal(String fileName, String fileContent) {
        try{
            String path = String.format("src\\HomeWork2\\%s.txt", fileName);
            File result = new File(path);
            FileWriter fileWriter = new FileWriter(result);
            fileWriter.write(fileContent);
            fileWriter.close();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    static void read(String localFilename){
        try{
            String path = String.format("src\\HomeWork2\\%s.txt", localFilename);
            FileReader fileReader =new FileReader(path);

            Logger logger = Logger.getLogger(Program.class.getName());
            ConsoleHandler consoleHandler = new ConsoleHandler();
            logger.addHandler(consoleHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            consoleHandler.setFormatter(simpleFormatter);
            StringBuilder stringBuilder = new StringBuilder();
            while(fileReader.ready()){
                stringBuilder.append((char)fileReader.read());
            }
            logger.info(stringBuilder.toString());
            fileReader.close();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    static boolean removeFromLocale(String fileName) {
        try{
            String path = String.format("src\\HomeWork2\\%s.txt", fileName);
            Files.delete(Path.of(path));
            System.out.println("File was deleted");
            return true;
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

    static void task3url() throws IOException {
        try(Scanner scanner = new Scanner(System.in)){
            String urlFile = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
            String fileName = "task3url";
            System.out.println("Enter your name: ");
            String newStr = change(scanner.nextLine(), download(urlFile));
            saveOnLocal(fileName, newStr);
            read(fileName);
            System.out.println(removeFromLocale(fileName));
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }

    static void task4calculator() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 2 numbers: ");
        System.out.println("first:");
        int a = scanner.nextInt();
        System.out.println("second:");
        int b = scanner.nextInt();
        System.out.println("Enter number for mathematical action:\n" +
                "1 - +;\n" +
                "2 - -;\n" +
                "3 - /;\n" +
                "4 - *");
        int num = scanner.nextInt();

        Logger logger = Logger.getLogger(Program.class.getName());
        FileHandler fileHandler = new FileHandler("src\\HomeWork2\\logCalculator.txt");
        logger.addHandler(fileHandler);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);

        switch (num){
            case 1:
                System.out.println(a + b);
                logger.log(Level.INFO, String.valueOf(a+b));
                break;
            case 2:
                System.out.println(a - b);
                logger.info(String.valueOf(a-b));
                break;
            case 3:
                if (b != 0) {
                    System.out.println((double) a / b);
                    logger.info(String.valueOf(a/b));
                }
                else {
                    System.out.println("Div by Zero");
                    logger.log(Level.WARNING, "Div by Zero");
                }
                break;
            case 4:
                System.out.println(a * b);
                logger.info(String.valueOf(a * b));
                break;
            default:
                System.out.println("No action");
                break;
        }
        scanner.close();
        System.out.println();
    }
}
