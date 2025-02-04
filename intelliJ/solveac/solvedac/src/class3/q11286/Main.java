package class3.q11286;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            int command = Integer.parseInt(br.readLine());

            if (command == 0) {
                if (heap.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(heap.poll()).append('\n');
                }
            } else {
                heap.add(command);
            }
        }

        System.out.println(sb);
    }
}
