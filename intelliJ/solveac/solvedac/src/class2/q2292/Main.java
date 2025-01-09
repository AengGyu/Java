package class2.q2292;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        /*
        * 각 층의 개수
        * 1 -> 1
        * 2 -> 2 ~ 7 7-2+1 = 6
        * 3 -> 8 ~ 19 19-8+1 = 12
        * 4 -> 20 ~ 37 37-20+1 = 18
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 1){
            System.out.println("1");
        }
        else{
            int layer = 1;
            int cnt = 2; // 새로운 층의 시작점 2 -> 8 -> 20 -> 38 -> ...

            while(cnt<=n){
                cnt = cnt + layer*6;
                layer++;
            }
            System.out.println(layer);
        }
    }
}
