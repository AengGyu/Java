package class3.q2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stair = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(maxScore(stair, n));
    }

    public static int maxScore(int[] stair, int n) {
        if (n == 1) return stair[1];
        if (n == 2) return stair[1] + stair[2];
        if (n == 3) return Math.max(stair[2] + stair[3], stair[1] + stair[3]);

        int[] max = new int[n + 1];
        max[1] = stair[1];
        max[2] = stair[1] + stair[2];
        max[3] = Math.max(stair[2] + stair[3], stair[1] + stair[3]);

        for (int i = 4; i <= n; i++) {
            max[i] = max[i-3] + stair[i-1] + stair[i];
            max[i] = Math.max(max[i], max[i-2] + stair[i]);
        }

        return max[n];
    }
}
