package class3.q10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static char[][] grid;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int normal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    normal++;
                    normalDFS(i, j);
                }
            }
        }

        visited = new boolean[n][n];
        int blind = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    blind++;
                    blindDFS(i, j);
                }
            }
        }

        System.out.println(normal + " " + blind);
    }

    private static void normalDFS(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n) {
                if (!visited[nextY][nextX] && grid[y][x] == grid[nextY][nextX]) {
                    normalDFS(nextY, nextX);
                }
            }
        }
    }

    private static void blindDFS(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < n) {
                if (!visited[nextY][nextX]) {
                    if (grid[y][x] == grid[nextY][nextX]) {
                        blindDFS(nextY, nextX);
                    } else if ((grid[y][x] == 'G' && grid[nextY][nextX] == 'R') ||
                            (grid[y][x] == 'R' && grid[nextY][nextX] == 'G')) {
                        blindDFS(nextY, nextX);
                    }
                }
            }
        }
    }
}
