package class2.q1259;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String num = br.readLine();
            if(num.equals("0")) break;
            StringBuilder sb = new StringBuilder(num);

            sb.reverse();
            if(sb.toString().equals(num)){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
    }
}
