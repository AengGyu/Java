import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int status = scanner.nextInt();  // 10진수 정수 입력

        // 비트 0~5: 온도 (0~31)
        int temperature = status & 0b00111111;

        // 비트 6: 에어컨 상태 (1이면 on, 0이면 off)
        String airConditioner = ((status >> 6) & 1) == 1 ? "on" : "off";

        // 비트 7: 주행 상태 (1이면 on, 0이면 off)
        String running = ((status >> 7) & 1) == 1 ? "on" : "off";

        // 결과 출력
        System.out.println("running: " + running);
        System.out.println("air conditioner: " + airConditioner);
        System.out.println("temperature: " + temperature);

        scanner.close();
    }
}