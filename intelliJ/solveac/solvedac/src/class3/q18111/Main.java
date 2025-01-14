package class3.q18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] ground = new int[n][m];
        int maxH = -1;
        int minH = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, ground[i][j]);
                minH = Math.min(minH, ground[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;

        for (int i = minH; i <= maxH; i++) {
            // 높이(i)로 만들 때 필요한 자원들 계산
            int addBlock = 0;
            int removeBlock = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (ground[j][k] > i) {
                        removeBlock += ground[j][k] - i;
                    } else if (ground[j][k] < i) {
                        addBlock += i - ground[j][k];
                    }
                }
            }

            if (addBlock <= removeBlock + b){
                int time = addBlock + removeBlock*2;
                if(time < minTime || (time == minTime && i > maxHeight)){
                    minTime = time;
                    maxHeight = i;
                }
            }
        }
        System.out.println(minTime + " " + maxHeight);
    }
}
