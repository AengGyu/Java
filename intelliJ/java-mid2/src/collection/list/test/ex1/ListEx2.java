package collection.list.test.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("n개의 정수를 입력하세요 (종료 0)");

        while(true){
            int num = scanner.nextInt();
            if(num == 0) break;
            list.add(num);
        }
        System.out.println("출력");
        for(int i=0;i<list.size()-1;i++){
            System.out.print(list.get(i)+", ");
        }
        System.out.println(list.getLast());
    }
}
