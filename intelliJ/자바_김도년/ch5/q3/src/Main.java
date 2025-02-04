import java.util.Scanner;

class BaseArray { // 클래스 이름 앞에 public 붙이면 안 됨.
    protected int array []; // 배열 메모리
    protected int nextIndex = 0; // 다음에 삽입할 배열에 대한 인덱스
    public BaseArray(int size) {
        array = new int [size];
    }
    public int length() { return array.length; }
    public void add(int n) { // 정수 n을 배열 끝에 추가
        if(nextIndex == array.length) return; // 배열이 꽉 찼으면 추가 안 함
        array[nextIndex] = n;
        nextIndex++;
    }
    public void print() {
        for(int n : array) System.out.print(n + " ");
        System.out.println();
    }
}

class BinaryArray extends BaseArray{
    private int treshhold;

    public BinaryArray(int size, int treshhold) {
        super(size);
        this.treshhold = treshhold;
    }
    public void add(int n) {
        if(nextIndex == array.length) return; // 배열이 꽉 찼으면 추가 안 함
        if(n <= treshhold) n = 0;
        else n = 1;
        array[nextIndex] = n;
        nextIndex++;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int treshhold = 50;
        BinaryArray bArray = new BinaryArray(10,treshhold);
        for(int i=0;i<bArray.length();i++) {
            int n = scanner.nextInt();
            bArray.add(n);
        }
        bArray.print();

        scanner.close();
    }

}
