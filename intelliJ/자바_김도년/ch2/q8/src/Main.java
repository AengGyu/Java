import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String course [] = {"C", "C++", "Python", "Java", "HTML5"};
        String grade [] = {"A", "B+", "B", "A+", "D"};

        while(true) {
            String str = scanner.next();
            if(str.equals("stop")) break;
            int flag = 0;
            for(int i=0;i<course.length;i++) {
                if(course[i].equals(str)) {
                    System.out.println(grade[i]);
                    flag = 1;
                }
            }
            if(flag == 0)
                System.out.println("none");
        }

        scanner.close();
    }

}
