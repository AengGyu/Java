package class2.q2231;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int generator = 1;

        while(generator<=n){
            int sum = generator;
            int tmp = generator;
            while(tmp>0){
                sum += tmp%10;
                tmp /= 10;
            }
            if(sum == n){
                System.out.println(generator);
                return;
            }
            generator++;
        }
        System.out.println("0");
    }
}
