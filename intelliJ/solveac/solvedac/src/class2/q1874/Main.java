package class2.q1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append('+').append('\n');

            while (!stack.isEmpty() && arr[idx] == stack.peek()) {
                stack.pop();
                idx++;
                sb.append('-').append('\n');
            }

        }
        if (stack.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}