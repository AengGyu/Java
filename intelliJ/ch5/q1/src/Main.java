import java.util.Scanner;

class Point { // 클래스 이름 앞에 public 붙이면 안 됨.
    private int x,y;

    public Point(int x, int y) { this.x = x; this.y = y; }

    public int getX() { return x; }

    public int getY() { return y; }

    protected void move(int x, int y) { this.x = x; this.y = y; }
}
class ColorPoint extends Point{
    private String color;

    public ColorPoint(int x,int y,String color) {
        super(x,y);
        this.color = color;
    }
    public void setXY(int x, int y) {
        move(x,y);
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String toString() {
        return "The point has " + color + " and " + "(" + getX() + "," + getY()+").";
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColorPoint cp = new ColorPoint(5,5,"RED");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        String color = scanner.next();
        cp.setXY(x,y);
        cp.setColor(color);
        System.out.println(cp);
        scanner.close();
    }

}
