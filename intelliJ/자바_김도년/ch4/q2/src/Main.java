import java.util.Scanner;

class Cuboid{
    int x;
    int y;
    int z;

    public Cuboid(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void increase(int x,int y, int z) {
        this.x += x;
        this.y += y;
        this.z += z;
    }
    public int volume() {
        return x*y*z;
    }
    public boolean isZero() {
        return this.volume() == 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();
        int xp = scanner.nextInt();
        int yp = scanner.nextInt();
        int zp = scanner.nextInt();

        Cuboid inst = new Cuboid(x,y,z);
        System.out.println("The volume of the cuboid is " + inst.volume()+".");
        inst.increase(xp, yp, zp);
        System.out.println("The volume of the cuboid is " + inst.volume()+".");
        if(inst.isZero()) // 증가된 이후의 부피
            System.out.println("The volume of the cuboid is zero." );
        else
            System.out.println("The volume of the cuboid is not zero." );
        scanner.close();
    }

}
