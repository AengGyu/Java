package class3.q1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] kevin;
    static int n, m;
    static int count;
    static int min = Integer.MAX_VALUE;
    static int minNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 1; i <= n; i++) {
            count = 0;
            visited = new boolean[n + 1];
            kevin = new int[n + 1];

            bfs(i);

            count = Arrays.stream(kevin).sum();
            if (min > count) {
                min = count;
                minNode = i;
            }
        }

        System.out.println(minNode);
    }

    private static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        kevin[start] = 0;

        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> edges = graph.get(node);

            for (Integer to : edges) {
                if (!visited[to]) {
                    queue.add(to);
                    kevin[to] = kevin[node] + 1;
                    visited[to] = true;
                }
            }
        }
    }
}
