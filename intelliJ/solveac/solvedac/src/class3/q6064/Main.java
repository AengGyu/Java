package class3.q6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, M, N, targetX, targetY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            int result = -1;

            for (int i = targetX; i <= M * N; i += M) {
                /**
                 * i번째 달력에서 targetX가 등장하므로
                 * i번째 달력에서 targetY를 만족하는지 확인
                 * i % N 을 하게 되면 N번째에 N이 돼야 하는데 0이 됨.
                 */
                if ((i - 1) % N + 1 == targetY) {
                    result = i;
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
