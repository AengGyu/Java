import java.util.Scanner;

class TV{
    String name;
    int inch;
    int price;

    public TV(String name,int inch, int price) {
        this.name = name;
        this.inch = inch;
        this.price =price;
    }
    public void show() {
        System.out.printf("%s %d-inch TV with the price of %d won\n",name,inch,price);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int inch = scanner.nextInt();
        int price = scanner.nextInt();

        TV tv = new TV(name,inch,price);
        tv.show();

        scanner.close();
    }

}
