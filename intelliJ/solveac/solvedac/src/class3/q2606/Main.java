package class3.q2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int conn = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1]; // 0번 제외, n개의 노드
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < conn; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        System.out.println(dfs(1));
    }

    private static int dfs(int i) {
        visited[i] = true;
        for (int j : graph[i]) {
            if (!visited[j]) {
                count++;
                dfs(j);
            }
        }

        return count;
    }
}
