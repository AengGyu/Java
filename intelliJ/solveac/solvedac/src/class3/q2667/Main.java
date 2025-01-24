package class3.q2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] house;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        house = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < row.length(); j++) {
                house[i][j] = row.charAt(j) - '0';
            }
        }

        int count = 0; // 총 단지 수
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && house[i][j] != 0) {
                    list.add(bfs(i, j));
                    count++;
                }
            }
        }
        Collections.sort(list);

        System.out.println(count);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static int bfs(int startY, int startX) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startY, startX});
        visited[startY][startX] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentY = current[0];
            int currentX = current[1];

            for (int i = 0; i < 4; i++) {
                int nextY = currentY + dy[i];
                int nextX = currentX + dx[i];

                if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                    if (!visited[nextY][nextX] && house[nextY][nextX] != 0) {
                        count++;
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }

        return count;
    }
}
