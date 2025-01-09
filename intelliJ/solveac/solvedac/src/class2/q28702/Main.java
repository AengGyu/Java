package class2.q28702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[3];

        for (int i = 0; i < 3; i++) {
            str[i] = br.readLine();
        }

        int k = 0;
        for (int i = 0; i < 3; i++) {
            if (str[i].charAt(0) >= '0' && str[i].charAt(0) <= '9') {
                k = Integer.parseInt(str[i]) + 3 - i;
                break;
            }
        }
        if (k % 3 == 0 && k % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (k % 3 == 0) {
            System.out.println("Fizz");
        } else if (k % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(k);
        }
    }
}
