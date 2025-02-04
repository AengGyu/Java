package class3.q7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int x, y, z;
    static int[][][] box;
    static Deque<int[]> queue = new ArrayDeque<>();
    static int[] dz = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dx = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        z = Integer.parseInt(st.nextToken());

        box = new int[z][y][x];

        int unripe = 0;
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < x; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if (box[i][j][k] == 1) {
                        queue.add(new int[]{i, j, k});
                    } else if (box[i][j][k] == 0) {
                        unripe++;
                    }
                }
            }
        }

        if (unripe == 0) {
            System.out.println(0);
            return;
        }

        int result = bfs();

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if(box[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs() {
        int max = 0;

        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int curZ = current[0], curY = current[1], curX = current[2];

            for (int i = 0; i < 6; i++) {
                int nextZ = curZ + dz[i];
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if(nextZ >= 0 && nextZ < z && nextY >= 0 && nextY < y && nextX >= 0 && nextX < x){
                    if(box[nextZ][nextY][nextX] == 0){
                        box[nextZ][nextY][nextX] = box[curZ][curY][curX] + 1;
                        max = Math.max(max, box[nextZ][nextY][nextX]);
                        queue.add(new int[] {nextZ, nextY, nextX});
                    }
                }
            }
        }

        return max - 1;
    }
}
