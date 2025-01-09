package lang.string.test;

public class TestString10 {
    public static void main(String[] args) {
        String fruits = "apple,banana,mango";
        String[] split = fruits.split(",");

        for (String s : split) {
            System.out.println(s);
        }

        String joined = String.join("->", split);
        System.out.println(joined);
    }
}
