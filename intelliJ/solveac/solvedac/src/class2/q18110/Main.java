package class2.q18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] level = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(level);

        int sum = 0;
        int start = (int) (Math.round((double) n * 0.15));
        int end = n - (int) (Math.round((double) n * 0.15));
        for (int i = start; i < end; i++) {
            sum += level[i];
        }

        System.out.println((int) (Math.round((double) sum / (end - start))));
    }
}
