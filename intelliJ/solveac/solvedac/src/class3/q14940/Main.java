package class3.q14940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        int startY = -1, startX = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                result[i][j] = -1;
                if (map[i][j] == 2) {
                    startY = i;
                    startX = j;
                } else if (map[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }

        bfs(startY, startX);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs(int y, int x) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        result[y][x] = 0;
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curY = current[0], curX = current[1];

            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m) {
                    if (!visited[nextY][nextX] && map[nextY][nextX] != 0) {
                        visited[nextY][nextX] = true;
                        result[nextY][nextX] = result[curY][curX] + 1;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
