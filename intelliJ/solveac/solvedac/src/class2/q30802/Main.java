package class2.q30802;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st2.nextToken());
        int P = Integer.parseInt(st2.nextToken());

        int bundleT = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num % T == 0) {
                bundleT = bundleT + num / T;
            } else if (num / T < 1) bundleT += 1;
            else {
                bundleT = bundleT + num / T + 1;
            }
        }
        System.out.println(bundleT);
        System.out.println(n / P + " " + n % P);
    }
}
