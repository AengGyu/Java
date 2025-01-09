package class2.q15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        BigInteger hashing = new BigInteger("0");

        for(int i=0;i<str.length();i++){
            hashing = hashing.add(BigInteger.valueOf(str.charAt(i)-'a'+1).multiply(BigInteger.valueOf(31).pow(i)));
        }
        hashing = hashing.mod(BigInteger.valueOf(1234567891));
        System.out.println(hashing);
    }
}
