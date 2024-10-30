import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int total = a*2000 + b*1000 + c*3000;

        System.out.println("Your total is " + total + " won.");

        scanner.close();
    }
}