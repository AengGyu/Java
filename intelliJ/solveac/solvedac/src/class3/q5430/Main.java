package class3.q5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String command = br.readLine();
            int size = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            LinkedList<Integer> list = new LinkedList<>();

            if (size > 0) {
                String[] parsing = arr.substring(1, arr.length() - 1).split(",");
                for (String s : parsing) {
                    list.add(Integer.parseInt(s));
                }
            }
            boolean flag = false;
            boolean reverse = false;
            for (char c : command.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (list.isEmpty()) {
                        flag = true;
                        break;
                    } else {
                        if (reverse) { // 뒤집힌 상태
                            list.removeLast();
                        } else {
                            list.removeFirst();
                        }
                    }
                }
            }

            if (flag) {
                sb.append("error\n");
            } else {
                sb.append('[');
                while (!list.isEmpty()) {
                    if (reverse) {
                        sb.append(list.removeLast());
                    } else {
                        sb.append(list.removeFirst());
                    }

                    if (!list.isEmpty()) {
                        sb.append(',');
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb);
    }
}
