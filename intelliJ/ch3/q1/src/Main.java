import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        int cnt = 0;
        while(true) {
            try {
                int num = scanner.nextInt();
                if (num == -1) break;
                else if (num < 0) System.out.println(num+" is excluded.");
                else {
                    cnt++;
                    total += num;
                }

            }
            catch(InputMismatchException e){
                String ex = scanner.next();
                System.out.println(ex +" is excluded.");
            }

        }
        System.out.printf("The sum is %d and the number is %d.\n", total,cnt);
        scanner.close();
    }

}
