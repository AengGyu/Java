import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        int N, sum = 0, weight = 0;
        N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            str = scanner.next();
            sum = 0;
            weight = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'O') {
                    weight++;
                    sum += weight;
                } else {
                    weight = 0;
                }
            }
            System.out.println(sum);
        }
    }
}