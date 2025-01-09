package class2.q1978;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = countPrime(arr);
        System.out.println(sum);
    }

    private static int countPrime(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isPrime(arr[i])) count++;
        }
        return count;
    }

    private static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < (int) (Math.sqrt(n)) + 1; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
