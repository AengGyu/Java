import java.util.Scanner;

abstract class Calc{
    public String errorMsg;
    protected int a,b;
    public void setValue(int a,int b) {
        this.a = a;
        this.b = b;
    }
    public abstract int calculate();
}
class Add extends Calc{
    public int calculate() {
        return a+b;
    }
}
class Sub extends Calc{
    public int calculate() {
        return a-b;
    }
}
class Mul extends Calc{
    public int calculate() {
        return a*b;
    }
}
class Div extends Calc{
    public int calculate() {
        if(b==0) {
            errorMsg = "You cannot divide by zero.";
            return 0;
        }
        return a/b;
    }
}
class Calculator{
    public Calculator() {

    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            int a =scanner.nextInt();
            int b = scanner.nextInt();
            String op = scanner.next();
            Calc obj;
            switch(op) {
                case "+" : obj = new Add(); break;
                case "-" : obj = new Sub();	break;
                case "*" : obj = new Mul();	break;
                case "/" : obj = new Div();	break;
                default :
                    System.out.println("Wrong Operator");
                    scanner.close();
                    return;
            }
            obj.setValue(a,b);
            int res = obj.calculate();
            if(obj.errorMsg == null) {
                System.out.println("Result is "+res+".");
            }
            else {
                System.out.println(obj.errorMsg+ " Exit");
                break;
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator cal = new Calculator();
        cal.run();
        scanner.close();
    }

}
