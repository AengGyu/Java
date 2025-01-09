package lang.string.test;

public class TestString9 {
    public static void main(String[] args) {
        String email = "hello@example.com";

        String[] splitted = email.split("@");
        String ID = splitted[0];
        String Domain = splitted[1];

        System.out.println("ID : " + ID);
        System.out.println("Domain : " + Domain);
    }
}
