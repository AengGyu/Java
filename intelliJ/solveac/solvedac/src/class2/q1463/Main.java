package class2.q1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(count(n));
    }

    public static int count(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 1;

        arr = new int[n + 1];
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i <= n; i++) {
            if (i % 3 == 0) {
                arr[i] = arr[i / 3] + 1;
            } else if (i % 2 == 0) {
                arr[i] = arr[i / 2] + 1;
            } else {
                arr[i] = arr[i - 1] + 1;
            }
//            System.out.printf("arr[%d] = %d\n", i,arr[i]);
        }
        return arr[n];
    }
}
