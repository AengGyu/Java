import java.util.Scanner;

class WordShuffleGame{
    private String words [] = { "vibrate", "extract", "nation", "connect", "lovely"};
    public WordShuffleGame() { }

    private String shuffle(String src) {
        char[] chars = src.toCharArray();
        int i,j;
        for(int k=0;k<chars.length;k++) {
            i = k;
            j = chars.length - 1 - k;
            if(i >= j) break;
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        String shuffleWord = new String(chars);
        return shuffleWord;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<words.length;i++) {
            String answerWord = words[i];
            String queryWord = shuffle(answerWord);
            System.out.println(queryWord);
            System.out.print(">>");
            String user = scanner.next();
            if(user.equals("Quit")) break;
            if(user.equals(answerWord)){
                System.out.println("Success!!!");
            }
            else {
                System.out.println("Fail!!! It is "+answerWord + ".");
            }
        }
        scanner.close();
    }
}

public class Main {

    public static void main(String[] args) {
        WordShuffleGame game = new WordShuffleGame();
        game.run();
    }

}
