import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coffee[] = {"Americano", "Cappuccino", "Latte", "Espresso"};
        int price[] = { 3000, 3500, 4000, 5000 };
        String menu;
        int num;
        boolean flag;
        while(true) {
            try {
                menu = scanner.next();
                if(menu.equals("Quit"))
                    break;
                num = scanner.nextInt();
                flag = false;
                if(num < 0) {
                    System.out.println("Please enter a positive integer for the number of cups.");
                }
                else {
                    for(int i = 0;i<coffee.length;i++) {
                        if(coffee[i].equals(menu)) {
                            System.out.printf("The price is %d won.\n",num*price[i]);
                            flag = true;
                        }
                    }
                    if(!flag) {
                        System.out.printf("%s is not available.\n", menu);
                    }
                }
            }
            catch(InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please enter a positive integer for the number of cups.");
            }
        }

        scanner.close();
    }

}
