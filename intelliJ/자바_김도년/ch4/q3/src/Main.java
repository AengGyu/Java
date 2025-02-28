import java.util.Scanner;

class Average{
    int[] arr = new int[10];
    private int nextIndex;

    public Average() {
        nextIndex = 0;
    }
    public void put(int n) {
        if(nextIndex < 10)
            arr[nextIndex++] = n;
    }
    public void showAll() {
        for(int i = 0; i<nextIndex;i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public double getAvg() {
        int sum = 0;
        for(int i=0;i<nextIndex;i++) {
            sum += arr[i];
        }
        return (double)(sum)/nextIndex;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Average avg = new Average();
        int n;
        while(true) {
            n = scanner.nextInt();
            if(n == -1) break;
            avg.put(n);
        }
        avg.showAll();
        System.out.printf("The average is %.1f.\n", avg.getAvg());
        scanner.close();
    }

}
