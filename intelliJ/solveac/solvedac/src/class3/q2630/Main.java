package class3.q2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int white = 0;
    static int blue = 0;

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        run(paper, new Point(0, 0), new Point(n, n));

        System.out.println(white);
        System.out.println(blue);
    }

    private static void run(int[][] paper, Point start, Point end) {
        int check = paper[start.x][start.y];
        boolean flag = true;

        for (int i = start.x; i < end.x; i++) {
            if (!flag) break;
            for (int j = start.y; j < end.y; j++) {
                if (paper[i][j] != check) {
                    flag = false; // 다른 숫자가 존재하면 flag = false -> 반복문 종료
                    break;
                }
            }
        }
        if (flag) { // 입력된 범위의 수가 모두 같으면 1 리턴
            if (check == 0) white++;
            else blue++;
            return;
        }
        int midX = (start.x + end.x) / 2;
        int midY = (start.y + end.y) / 2;

        run(paper, start, new Point(midX, midY));
        run(paper, new Point(midX, start.y), new Point(end.x, midY));
        run(paper, new Point(start.x, midY), new Point(midX, end.y));
        run(paper, new Point(midX, midY), end);
    }
}
