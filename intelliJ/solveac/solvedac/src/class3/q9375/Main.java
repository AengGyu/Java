package class3.q9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            // key : category, value = name
            HashMap<String, ArrayList<String>> clothes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();
                if (!clothes.containsKey(category)) {
                    ArrayList<String> names = new ArrayList<>();
                    names.add(name);
                    clothes.put(category, names);
                } else {
                    clothes.get(category).add(name);
                }
            }
            int numOfCase = 1;
            Set<String> categories = clothes.keySet();
            for (String category : categories) {
                numOfCase *= (clothes.get(category).size() + 1);
            }
            System.out.println(numOfCase - 1);
        }
    }
}
