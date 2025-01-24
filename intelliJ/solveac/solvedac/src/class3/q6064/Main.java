package class3.q6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, M, N, targetX, targetY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            int count = 0;

            count = find(1, 1, count + 1);
            System.out.println(count);
        }
    }

    private static int find(int startX, int startY, int count) {
        if (startX == targetX && startY == targetY)
            return count;

        if (startX == M && startY == N) return -1;

        if (startX < M) startX = startX + 1;
        else startX = 1;

        if (startY < N) startY = startY + 1;
        else startY = 1;


        count = find(startX, startY, count + 1);

        return count;
    }
}
