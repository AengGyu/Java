package class3.q11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(funct(n));
    }

    private static int funct(int n) {
        if (n == 1) return 1;
        if (n == 2) return 3;

        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 3;
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2] * 2) % 10007;
        }

        return arr[n];
    }
}
