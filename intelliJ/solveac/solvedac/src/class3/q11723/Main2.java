package class3.q11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int bit = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add":
                    int inputData = Integer.parseInt(st.nextToken());
                    // 비트는 0번째부터 시작하니까 input - 1 번째가 해당 값의 자리임
                    // 예를 들어서 4 같은 경우는 1000 인데 비트열에서의 인덱스는 3임
                    bit = bit | (1 << (inputData-1));
                    break;
                case "remove":
                    int removeData = Integer.parseInt(st.nextToken());
                    // 삭제하려는 값의 비트열을 구하고 그 비트의 ~을 한 다음에 현재 비트열과 and 연산을 하면 됨
                    bit = bit & ~(1 << (removeData-1));
                    break;
                case "check":
                    int checkData = Integer.parseInt(st.nextToken());
                    // 해당 수와 and 연산을 했을 때
                    sb.append((bit & (1 << checkData - 1)) != 0 ? 1 : 0).append('\n');
                    break;
                case "toggle":
                    int toggleData = Integer.parseInt(st.nextToken());
                    bit = bit ^ (1 << (toggleData - 1));
                    break;
                case "all":
                    // 모든 비트열을 1로 채우기
                    bit = ~0;
                    break;
                case "empty":
                    bit = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
