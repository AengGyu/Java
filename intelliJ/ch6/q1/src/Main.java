import java.util.Scanner;

class Student{
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public String toString() {
        return name +"'s id is " + id+".";
    }
    public boolean equals(Object obj) {
        Student b = (Student)obj;
        if(this.name.equals(b.name) && this.id == b.id)
            return true;
        else
            return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int id = scanner.nextInt();
        Student a = new Student(name,id);
        name = scanner.next();
        id = scanner.nextInt();
        Student b = new Student(name,id);
        System.out.println(a);
        if(a.equals(b))
            System.out.println("They are the same.");
        else
            System.out.println("They are different.");
    }

}
