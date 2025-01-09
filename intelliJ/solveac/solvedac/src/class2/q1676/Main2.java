package class2.q1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = i;
            while(tmp%5==0){
                tmp /= 5;
                count++;
            }
        }
        
        System.out.println(count);
    }
}
