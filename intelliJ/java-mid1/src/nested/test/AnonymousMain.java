package nested.test;

public class AnonymousMain {
    public static void main(String[] args) {
        Hello hello = new Hello(){
            public void hello(){
                System.out.println("AnonymousMain.hello");
            }
        };
        hello.hello();
    }
}
