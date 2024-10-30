import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int birth = scanner.nextInt(); // 8자리 20020115

        int year = birth/10000;
        int month = (birth % 10000) / 100;
        int day = birth % 100;

        System.out.println("year " + year + " month " + month + " date " + day);
    }
}

//year 2001 month 3 date 16