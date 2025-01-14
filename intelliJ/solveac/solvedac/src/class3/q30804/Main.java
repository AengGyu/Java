package class3.q30804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fruit = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < fruit.length; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < n; right++) {
            fruitCount.put(fruit[right], fruitCount.getOrDefault(fruit[right], 0) + 1);

            while (fruitCount.size() > 2) {
                fruitCount.put(fruit[left], fruitCount.get(fruit[left]) - 1);
                if (fruitCount.get(fruit[left]) == 0) fruitCount.remove(fruit[left]);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        System.out.println(maxLen);
    }
}
