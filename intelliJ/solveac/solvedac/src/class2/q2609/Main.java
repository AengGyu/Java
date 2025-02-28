package class2.q2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));
    }

    private static int lcm(int a, int b) {
        return (a*b)/ gcd(a,b);
    }

    private static int gcd(int a, int b) {
        if(b == 0) return a;

        return gcd(b, a%b);
    }
}
