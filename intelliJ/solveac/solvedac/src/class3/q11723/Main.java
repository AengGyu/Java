package class3.q11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        Set<Integer> fullSet = new HashSet<>();
        for (int i = 1; i <= 20; i++) fullSet.add(i);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add":
                    int inputData = Integer.parseInt(st.nextToken());
                    if (!set.contains((inputData))) {
                        set.add(inputData);
                    }
                    break;
                case "remove":
                    int removeData = Integer.parseInt(st.nextToken());
                    if (set.contains((removeData))) {
                        set.remove(removeData);
                    }
                    break;
                case "check":
                    int checkData = Integer.parseInt(st.nextToken());
                    if (set.contains((checkData))) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "toggle":
                    int toggleData = Integer.parseInt(st.nextToken());
                    if (set.contains(toggleData)) {
                        set.remove(toggleData);
                    } else {
                        set.add(toggleData);
                    }
                    break;
                case "all":
                    set.addAll(fullSet);
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        System.out.println(sb);
    }
}
