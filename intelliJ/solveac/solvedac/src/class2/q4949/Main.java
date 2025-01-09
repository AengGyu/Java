package class2.q4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String sentence = br.readLine();
            if (sentence.equals(".")) break;
            if (checkBalance(sentence)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    public static boolean checkBalance(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                stack.push(str.charAt(i));
            }
            if (str.charAt(i) == ')') {
                if(stack.isEmpty()) return false;
                if (stack.pop() != '(') return false;
            }
            if (str.charAt(i) == ']') {
                if(stack.isEmpty()) return false;
                if (stack.pop() != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}
