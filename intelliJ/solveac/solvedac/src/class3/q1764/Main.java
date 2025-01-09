package class3.q1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> noHear = new HashSet<>();
        for (int i = 0; i < n; i++) {
            noHear.add(br.readLine());
        }

        Set<String> noSee = new HashSet<>();
        for (int i = 0; i < m; i++) {
            noSee.add(br.readLine());
        }

        Set<String> noHearAndNoSee = new HashSet<>(noHear);
        noHearAndNoSee.retainAll(noSee);
        List<String> list = new ArrayList<>(noHearAndNoSee);
        list.sort(null);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append('\n');
        for (String name : list) {
            sb.append(name).append('\n');
        }
        System.out.println(sb);
    }
}
