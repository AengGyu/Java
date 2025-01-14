package class3.q1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        StringTokenizer st = new StringTokenizer(expression, "-");
        int sum = 111111;
        while(st.hasMoreTokens()){
            //55-50+40
            //55, 50+40
            int middleSum = 0;
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            while(st2.hasMoreTokens()){
                middleSum += Integer.parseInt(st2.nextToken());
            }

            if(sum == 111111){
                sum = middleSum;
            }else{
                sum -= middleSum;
            }
        }
        System.out.println(sum);
    }
}
