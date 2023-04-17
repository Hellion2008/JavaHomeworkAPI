package HomeWork1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws IOException {
        String menu = "Enter number of task:\n" +
                "1 - triangle\n" +
                "2 - factorial\n" +
                "3 - primeNumbers\n" +
                "4 - calculator\n" +
                "5 - equation\n" +
                "6 - sum over even indices\n" +
                "7 - set\n" +
                "0 - exit";
        System.out.println(menu);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        do{
            switch (num) {
                case 1: triangle(); break;
                case 2: factorial(); break;
                case 3: primeNumbers(); break;
                case 4:calculator();break;
                case 5:equation(); break;
                case 6:task6array(); break;
                case 7:task7list(); break;
                case 0: System.exit(0);
                default: System.out.println("No action");
            }
            System.out.println(menu);
            System.out.println();
            num = Integer.parseInt(reader.readLine());
        } while(num != 0 );
    }

    static void triangle(){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter N:");
            int n = scanner.nextInt();
            double res = 0.5 * n * (n + 1);
            System.out.printf("Triangle number \"%d\": %.0f\n", n, res);
        }
        System.out.println();
    }

    static void factorial(){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter N:");
            int n = scanner.nextInt();
            int res = 1;
            for (int i = 1; i <= n; i++) {
                res *= i;
            }
            System.out.printf("Factorial %d: %d\n", n, res);
        }
        System.out.println();
    }

    static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void primeNumbers() {
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) System.out.println(i);
        }
        System.out.println();
    }

    static void calculator(){
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
        switch (num){
            case 1:
                System.out.println(a + b);
                break;
            case 2:
                System.out.println(a - b);
                break;
            case 3:
                if (b != 0) System.out.println((double) a / b);
                else System.out.println("Div by Zero");
                break;
            case 4:
                System.out.println(a * b);
                break;
            default:
                System.out.println("No action");
                break;
        }
        scanner.close();
        System.out.println();
    }

    static void  equation(){
        int a = 20, b = 5, c = 69;
        boolean isAns = false;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int ans = (a + i) + (j * 10 + b);
                if ( ans == c){
                    System.out.printf("%d + %d = %d\n", a + i, j * 10 + b, c);
                    isAns = true;
                }
            }
        }
        if (!isAns) System.out.println("No solutions");
        System.out.println();
    }

    static void task6array(){
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Enter length of array: ");
            int array[] = new int[sc.nextInt()];
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                System.out.printf("Enter %d element: ", i);
                array[i] = sc.nextInt();
                if (i % 2 == 0)
                        sum += array[i];
            }
            System.out.println(sum);
            for (int i = 0; i < array.length; i += 2) {
                System.out.println(array[i]);
            }

        }
        System.out.println();
    }

    static  void task7list(){
        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Enter list in one line: ");
            String[] s = scanner.nextLine().split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int count = 0;
            for (int i = 0; i < arr.length; i++){
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] == arr[j]){
                        count++;
                    }
                }
                if (count < 2){
                    System.out.println(arr[i]);
                }
                count = 0;
            }
        }
        System.out.println();
    }
}
