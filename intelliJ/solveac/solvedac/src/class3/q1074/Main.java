package class3.q1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, r, c;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);

        func(size, 0, 0);
    }

    private static void func(int size, int i, int j) {
        if (size == 1) {
            System.out.println(count);
            return;
        }

        int half = size / 2;

        if (r < i + half && c < j + half) { // 좌상
            func(half, i, j);
        } else if (r < i + half && c >= j + half) { // 우상
            count += half * half;
            func(half, i, j + half);
        } else if (r >= i + half && c < j + half) { // 좌하
            count += half * half * 2;
            func(half, i + half, j);
        } else { // 우하
            count += half * half * 3;
            func(half, i + half, j + half);
        }
    }
}
