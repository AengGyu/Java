import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dollar = scanner.nextInt();
        int won = dollar * 1200;

        System.out.println("$" + dollar + "=" + won + " won");

        scanner.close();
    }
}