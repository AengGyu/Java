package class3.q1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(getCount(n));
    }

    private static int getCount(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 1;

        int[] count = new int[n + 1];
        count[1] = 0;
        count[2] = 1;
        count[3] = 1;

        for (int i = 4; i <= n; i++) {
            int min = count[i - 1] + 1;
            if (i % 3 == 0) min = Math.min(min, count[i / 3] + 1);
            if (i % 2 == 0) min = Math.min(min, count[i / 2] + 1);
            count[i] = min;
        }

        return count[n];
    }
}
