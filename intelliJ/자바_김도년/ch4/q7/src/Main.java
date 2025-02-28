import java.util.Scanner;

class Dictionary{
    private static String[] kor = { "sarang", "agi", "don", "mirae", "heemang" };
    private static String[] eng = { "love", "baby", "money", "future", "hope" };

    public static String kor2eng(String word) {
        for(int i=0;i<kor.length;i++) {
            if(kor[i].equals(word)) {
                return eng[i];
            }
        }
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        while(true) {
            word = scanner.next();
            if(word.equals("exit")) {
                System.out.println("The program has ended.");
                break;
            }
            String eng = Dictionary.kor2eng(word);
            if(eng == null) {
                System.out.println(word +" is not in my dictionary.");
            }
            else {
                System.out.println(word +" is " + eng +" in English.");
            }
        }

        scanner.close();
    }

}
