package class3.q1927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int command = Integer.parseInt(br.readLine());

            if (command == 0) {
                if (minHeap.isEmpty()) {
                    sb.append('0').append('\n');
                } else {
                    sb.append(minHeap.poll()).append('\n');
                }
            } else {
                minHeap.add(command);
            }
        }
        System.out.println(sb);
    }
}
