import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < 3; i++) {
            String plan = scanner.nextLine();
            System.out.println(checkCandy(plan, A, B, C));
        }
    }

    public static String checkCandy(String plan, int A, int B, int C) {
        for(char c : plan.toCharArray()){
            if(c == 'A'){
                if(A>0) A--;
                else return "Candy is not enough!";
            }
            else if(c == 'B'){
                if(B>0) B--;
                else return "Candy is not enough!";
            }
            else if(c == 'C'){
                if(C>0) C--;
                else return "Candy is not enough!";
            }
        }
        if(plan.contains("AAA") || plan.contains("BBB") || plan.contains("CCC")){
            return "Tired of candy!";
        }
        else return "Tastes good!";
    }
}
