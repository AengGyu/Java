package class3.q11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int command = Integer.parseInt(br.readLine());

            if (command == 0) {
                if (maxHeap.isEmpty()) {
                    sb.append('0').append('\n');
                } else {
                    sb.append(maxHeap.poll()).append('\n');
                }
            } else {
                maxHeap.add(command);
            }
        }
        System.out.println(sb);
    }
}
