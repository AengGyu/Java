package class3.q1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> dict1 = new HashMap<>();
        HashMap<Integer, String> dict2 = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            dict1.put(name, i);
            dict2.put(i, name);
        }

        for (int i = 0; i < m; i++) {
            String search = br.readLine();
            if (search.charAt(0) >= '0' && search.charAt(0) <= '9') {
                System.out.println(dict2.get(Integer.valueOf(search)));
            } else {
                System.out.println(dict1.get(search));
            }
        }
    }
}
