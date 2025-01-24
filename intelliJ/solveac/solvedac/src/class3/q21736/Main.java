package class3.q21736;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static char[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startRow = 0, startCol = 0;
        graph = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                graph[i][j] = line.charAt(j);
                if (graph[i][j] == 'I') {
                    startRow = i;
                    startCol = j;
                }
            }
        }
        dfs(startRow, startCol);
        System.out.println(count == 0 ? "TT" : count);
    }

    private static void dfs(int startRow, int startCol) {
        visited[startRow][startCol] = true;

        if (graph[startRow][startCol] == 'P') count++;

        for (int i = 0; i < 4; i++) {
            int currentRow = startRow + dx[i];
            int currentCol = startCol + dy[i];

            if ((currentRow >= 0 && currentRow < n) && (currentCol >= 0 && currentCol < m)) {
                if (!visited[currentRow][currentCol] && graph[currentRow][currentCol] != 'X') {
                    dfs(currentRow, currentCol);
                }
            }
        }
    }
}
