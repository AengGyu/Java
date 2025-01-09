package class2.q9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i= 0; i<T;i++){
            System.out.println(func(Integer.parseInt(br.readLine())));
        }
    }
    public static int func(int n){
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for(int i=3; i<=n;i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }

        return arr[n];
    }
}
