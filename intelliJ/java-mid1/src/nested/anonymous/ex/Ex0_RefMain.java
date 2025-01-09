package nested.anonymous.ex;

public class Ex0_RefMain {

    public static void hello(String name){
        System.out.println("프로그램 시작");
        System.out.println("Hello " + name);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        hello("Java");
        hello("Spring");
    }
}
