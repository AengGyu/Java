package class3.q11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] graph;
    static int[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(visited[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(int start, int current) {
        for (int i = 0; i < n; i++) {
            if (graph[current][i] == 1 && visited[start][i] == 0) {
                visited[start][i] = 1;
                dfs(start, i);
            }
        }
    }
}
