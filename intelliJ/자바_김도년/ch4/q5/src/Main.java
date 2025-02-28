import java.util.Scanner;

class Account{
    int balance;

    public Account(int money) {
        balance = money;
    }
    public void deposit(int money) {
        balance += money;
    }
    public void deposit(int[] bulk) {
        for(int i=0;i<bulk.length;i++) {
            balance += bulk[i];
        }
    }
    public int getBalance() {
        return balance;
    }
    public int withdraw(int money) {
        if(balance < money) {
            money = balance;
            balance = 0;
            return money;
        }
        else {
            balance -= money;
            return money;
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = scanner.nextInt();
        Account account = new Account(money);
        money = scanner.nextInt();
        account.deposit(money);
        System.out.println("The balance is "+account.getBalance()+".");
        int[] bulk = new int[4];
        for(int i=0;i<4;i++) {
            bulk[i] = scanner.nextInt();
        }
        account.deposit(bulk);
        System.out.println("The balance is "+account.getBalance()+".");
        money = scanner.nextInt();
        int wMoney = account.withdraw(money);
        if (wMoney < money) // 인출하고자하는 금액보다 작은 돈이 인출된 경우
            System.out.println("Withdraw only "+wMoney+"."); // 잔금이 1000원보다 작은 경우
        else
            System.out.println("Withdraw "+wMoney+".");
        System.out.println("The balance is "+account.getBalance()+".");
        scanner.close();
    }

}
