import java.util.Scanner;

class Memo{
    String name,time,content;

    public Memo(String name,String time, String content) {
        this.name = name;
        this.time = time;
        this.content = content;
    }
    public boolean isSameName(Memo memo) {
        return this.name.equals(memo.name);
    }
    public String getName() {
        return this.name;
    }
    public void show() {
        System.out.println(name+ ", "+ time +" "+ content);
    }
    public int length() {
        return content.length();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String st1,st2,st3;
        st1 = scanner.next();
        st2 = scanner.next();
        scanner.nextLine();
        st3 = scanner.nextLine();
        Memo a = new Memo(st1,st2,st3);
        st1 = scanner.next();
        st2 = scanner.next();
        scanner.nextLine();
        st3 = scanner.nextLine();
        Memo b = new Memo(st1,st2,st3);

        a.show();
        if(a.isSameName(b)) {
            System.out.println("They are the same.");
        }
        else {
            System.out.println("They are different.");
        }
        System.out.println(a.getName() + " memo length is " + a.length() +".");
        scanner.close();
    }

}
