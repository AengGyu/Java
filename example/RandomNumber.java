import java.util.Scanner;
import java.util.Random;

public class RandomNumber {
    public static void main(String[] args){
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int z = scanner.nextInt();

        // a <= rand <= z
        System.out.println(a + rand.nextInt(z-a+1));
    }
}
