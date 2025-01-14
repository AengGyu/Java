package class3.q18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] point = new int[n];
        int[] point2 = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            point[i] = Integer.parseInt(st.nextToken());
            point2[i] = point[i];
        }

        Arrays.sort(point2);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int num : point2) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : point) {
            sb.append(map.get(num)).append(' ');
        }
        System.out.println(sb);
    }
}
