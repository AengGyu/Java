import java.util.Scanner;

public class Main {
    static public void main(String[] args) {
        int num = 0;
        // go 문자열 입력
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input go to start>>");
            String input = scanner.next();
            if (input.equals("go")) {
                System.out.print("Input an integer>>");
                num = scanner.nextInt();
                break;
            }
        }
        scanner.close();
        // 스레드 생성 및 스레드 실행 시작
        CountingThread th = new CountingThread(num);
        th.start();
    }
}

class CountingThread extends Thread {
    private int num;

    CountingThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("A thread starts.");
        for (int i = 1; i <= num; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nThe thread ends.");
    }
}