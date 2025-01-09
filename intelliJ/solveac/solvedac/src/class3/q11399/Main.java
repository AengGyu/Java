package class3.q11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] time = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);

        int[] totalTime = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            totalTime[i] = time[i] + totalTime[i - 1];
        }
        int sum = 0;
        for (int t : totalTime) {
            sum += t;
        }

        System.out.println(sum);
    }
}
