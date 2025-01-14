package practice.q21737;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String expression = br.readLine();

        long currentResult = 0; // 현재 결과값
        StringBuilder sb = new StringBuilder(); // 숫자를 저장할 StringBuilder
        StringBuilder output = new StringBuilder(); // 결과 저장
        boolean firstNumber = true; // 첫 번째 숫자 처리 여부

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                sb.append(ch); // 숫자를 추가
            } else {
                if (sb.length() > 0) {
                    long number = Long.parseLong(sb.toString());
                    sb.setLength(0); // 숫자를 초기화

                    if (firstNumber) {
                        currentResult = number; // 첫 번째 숫자 초기화
                        firstNumber = false;
                    } else {
                        // 연산 수행
                        switch (ch) {
                            case 'S':
                                currentResult -= number;
                                break;
                            case 'M':
                                currentResult *= number;
                                break;
                            case 'U':
                                if (currentResult < 0) {
                                    currentResult = -(-currentResult / number);
                                } else {
                                    currentResult /= number;
                                }
                                break;
                            case 'P':
                                currentResult += number;
                                break;
                        }
                    }
                }

                if (ch == 'C') {
                    output.append(currentResult).append(" "); // C 연산자를 만나면 결과 저장
                }
            }
        }

        // 마지막 숫자 처리
        if (sb.length() > 0) {
            long number = Long.parseLong(sb.toString());
            if (firstNumber) {
                currentResult = number;
            }
        }

        // 출력
        if (output.length() == 0) {
            System.out.println("NO OUTPUT");
        } else {
            System.out.println(output.toString().trim());
        }
    }
}