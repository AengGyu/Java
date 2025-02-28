import java.util.Scanner;

class Point { // 클래스 이름 앞에 public 붙이면 안 됨.
    private int x,y;

    public Point(int x, int y) { this.x = x; this.y = y; }

    public int getX() { return x; }

    public int getY() { return y; }

    protected void move(int x, int y) { this.x = x; this.y = y; }
}

class Point3D extends Point{
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z +")";
    }
    public void moveUp(int n) {
        z += n;
    }
    public void moveDown(int n) {
        z -= n;
    }
    public void move(int x, int y, int z) {
        super.move(x, y);
        this.z = z;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point3D p = new Point3D(3, 2, 1);
        System.out.println("The point is " + p.toString() + ".");
        int z = scanner.nextInt();
        p.moveUp(z); // z 축으로 3 이동
        System.out.println("The point is " + p.toString() + ".");
        z = scanner.nextInt();
        p.moveDown(z); // z 축으로 -2 이동
        System.out.println("The point is " + p.toString() + ".");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        p.move(x, y); // x=10, y=10으로 이동
        System.out.println("The point is " + p.toString() + ".");
        x = scanner.nextInt();
        y = scanner.nextInt();
        z = scanner.nextInt();
        p.move(x, y, z);
        System.out.println("The point is " + p.toString() + ".");
        scanner.close();
    }

}
