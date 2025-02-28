package class2.q2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.addLast(i);
        }

        while (list.size() > 1) {
            list.removeFirst();
            list.addLast(list.removeFirst());
        }

        System.out.println(list.getFirst());
    }
}
