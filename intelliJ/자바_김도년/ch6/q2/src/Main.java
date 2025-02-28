import java.util.Scanner;

public class Main {
    public static void error(String msg, String input) {
        System.out.println(msg + ":"+input);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        int sum;
        boolean errorFlag;
        while(true) {
            sum = 0;
            errorFlag = false;
            str = scanner.nextLine();
            if(str.equals("Quit")) break;

            str = str.toUpperCase();
            String[] arr = str.split(" ");

            for(int i=0;i<arr.length;i++) {
                switch(arr[i]) {
                    case "A": sum += 100;break;
                    case "B": sum += 90; break;
                    case "C": sum += 80; break;
                    case "D": sum += 70; break;
                    case "F": break;
                    default:
                        error("Input error", arr[i]);
                        errorFlag = true;
                        break;
                }
            }
            if(!errorFlag) {
                System.out.printf("Average is %.2f.", (double)sum/arr.length);
            }
        }
        scanner.close();
    }

}
