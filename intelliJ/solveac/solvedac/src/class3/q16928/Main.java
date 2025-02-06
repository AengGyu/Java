package class3.q16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            board[from] = to;
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0}); // 현재 위치, 카운트
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cur = current[0];
            int count = current[1];

            if (cur == 100) return count;

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;
                if (next > 100) continue;
                next = board[next];

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, count + 1});
                }
            }
        }
        return 0; // 이 경우는 없음
    }
}
