package class3.q1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) System.out.println(0);
        else {
            bfs(n);
        }
    }

    private static void bfs(int n) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = current + 1;
                } else if (i == 1) {
                    next = current - 1;
                } else {
                    next = current * 2;
                }

                if (next == k) {
                    System.out.println(visited[current]);
                    return;
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[current] + 1;
                }
            }
        }
    }
}
