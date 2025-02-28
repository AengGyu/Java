import java.util.Scanner;

interface Shape {
    static final double PI = 3.14;
    void draw(); // 도형을 그리는 추상 메소드. 상속받으면 구현 필요
    double getArea(); // 도형의 면적을 리턴하는 추상 메소드. 상속받으면 구현 필요
    default public void redraw() { // 디폴트 메소드
        System.out.print("redraw ");
        draw( );
    }
}
class Circle implements Shape{
    private int radius;
    public Circle(int radius) {
        this.radius = radius;
    }
    public void draw() {
        System.out.println("circle with radius "+radius);
    }
    public double getArea() {
        return PI*radius*radius;
    }
}

class Rect implements Shape{
    private int width,height;
    public Rect(int width,int height) {
        this.width = width;
        this.height = height;
    }
    public void draw() {
        System.out.println(width + "x" +height +" rectangular");
    }
    public double getArea() {
        return width*height;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape[] list = new Shape[3];
        int x,y;
        x = scanner.nextInt();
        list[0] = new Circle(x);
        x = scanner.nextInt();
        y = scanner.nextInt();
        list[1] = new Rect(x,y);
        x=scanner.nextInt();
        y=scanner.nextInt();
        list[2] = new Rect(x,y);

        for(int i=0;i<3;i++) list[i].redraw();
        for(int i=0;i<3;i++) {
            System.out.printf("The area is %.1f.\n",list[i].getArea());
        }
        scanner.close();
    }

}
