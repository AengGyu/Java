package class3.q7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[][] box;
    static int n, m;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Deque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n][m];

        int unripe = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1) {
                    queue.add(new int[]{i, j});
                } else if (box[i][j] == 0) {
                    unripe++;
                }
            }
        }

        if (unripe == 0) {
            System.out.println(0);
            return;
        }

        int result = bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs() {
        int max = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curY = current[0], curX = current[1];

            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    if (box[nextY][nextX] == 0) {
                        box[nextY][nextX] = box[curY][curX] + 1;
                        max = Math.max(max, box[nextY][nextX]);
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }

        return max - 1;
    }
}
