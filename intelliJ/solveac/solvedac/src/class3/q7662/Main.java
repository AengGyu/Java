package class3.q7662;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (command.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }

                    int remove = (n == 1) ? map.lastKey() : map.firstKey();
                    if (map.get(remove) == 1) {
                        map.remove(remove);
                    } else {
                        map.put(remove, map.get(remove) - 1);
                    }
                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else{
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append('\n');
            }
        }
        System.out.println(sb);
    }
}
