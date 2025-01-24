package class3.q1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(start);
        System.out.println();
        visited = new boolean[n + 1];
        bfs(start);
    }

    private static void dfs(int start) {
        visited[start] = true;
        List<Integer> edges = graph.get(start);
        System.out.print(start + " ");

        for (Integer to : edges) {
            if (!visited[to]) dfs(to);
        }
    }

    private static void bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        System.out.print(start + " ");

        while (!queue.isEmpty()) {
            List<Integer> edges = graph.get(queue.poll());
            for (Integer to : edges) {
                if (!visited[to]) {
                    visited[to] = true;
                    System.out.print(to + " ");
                    queue.add(to);
                }
            }
        }
    }
}
