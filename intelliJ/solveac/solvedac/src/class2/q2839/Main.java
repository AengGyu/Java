package class2.q2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt5 = n / 5;
        int cnt3 = 0;
        int cnt = -1;

        while (cnt5 >= 0) {
            int remaining = n - cnt5 * 5;
            if (remaining % 3 == 0) {
                cnt3 = remaining / 3;
                cnt = cnt5 + cnt3;
                break;
            }
            cnt5--;
        }
        System.out.println(cnt);
    }
}
