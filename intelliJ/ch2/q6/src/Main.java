import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        byte status = Byte.parseByte(str,2);

        if((status & 0b00000001) != 0) { //power
            System.out.println("power: on");
        }
        else {
            System.out.println("power: off");
        }

        if((status & 0b00000010) != 0) { // door
            System.out.println("door: closed");
        }
        else {
            System.out.println("door: open");
        }

        if((status & 0b00000100) != 0) { //light
            System.out.println("light: on");
        }
        else {
            System.out.println("light: off");
        }

        if((status & 0b00001000) != 0) { //temperature
            System.out.println("temperature: less than 3");
        }
        else {
            System.out.println("temperature: greater than or equal to 3");
        }
    }
}