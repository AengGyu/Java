package practice.q21734;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int sum = getSum(str.charAt(i));
            for (int j = 0; j < sum; j++) {
                System.out.print(str.charAt(i));
            }
            System.out.println();
        }
    }

    private static int getSum(char c) {
        int n = c;
        int sum = 0;
        while(n>0){
            sum += n%10;
            n /= 10;
        }

        return sum;
    }
}
