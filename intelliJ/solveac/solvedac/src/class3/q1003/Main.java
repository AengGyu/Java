package class3.q1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] count = getCount(n);
            System.out.println(count[0] + " " + count[1]);
        }
        System.out.println(sb);
    }

    public static int[] getCount(int n) {
        if (n == 0) return new int[]{1, 0};
        if (n == 1) return new int[]{0, 1};

        ArrayList<int[]> count = new ArrayList<>();
        count.add(new int[]{1, 0});
        count.add(new int[]{0, 1});

        for (int i = 2; i <= n; i++) {
            count.add(new int[]{(count.get(i - 2)[0] + count.get(i - 1)[0]),
                    (count.get(i - 2)[1] + count.get(i - 1)[1])});
        }

        return count.get(n);
    }
}
