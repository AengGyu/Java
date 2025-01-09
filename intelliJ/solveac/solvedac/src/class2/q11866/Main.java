package class2.q11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] circle = new int[n];
        for (int i = 0; i < n; i++) {
            circle[i] = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');

        int index = 0;
        int count = 0; // 자리를 치운 횟수

        while (count < n) {
            int step = 0; // 치울 자리를 탐색한 횟수
            while (true) {
                if (circle[index] != 0) {
                    step++;
                }
                if (step == k) break;
                index = (index + 1) % n;
            }
            sb.append(circle[index]);
            circle[index] = 0;
            count++;
            if (count < n) {
                sb.append(", ");
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}
