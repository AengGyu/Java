package class3.q9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());
            System.out.println(fucnt(input));
        }
    }

    private static int fucnt(int input) {
        if (input == 1) return 1;
        if (input == 2) return 2;
        if (input == 3) return 4;

        int[] arr = new int[input + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4; i <= input; i++) {
            arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
        }

        return arr[input];
    }

}
