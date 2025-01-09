package class3.q9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(p(n));
        }
    }

    private static long p(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 1;
        if (n == 4) return 2;
        if (n == 5) return 2;

        long[] arr = new long[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;

        for (int i = 6; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 5];
        }
        return arr[n];
    }
}