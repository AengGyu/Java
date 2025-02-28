import java.util.Scanner;

class ArrayUtil{
    public static int[] concat(int[] a, int[] b) {
        int[] arr = new int[8];
        int idx = 0;
        for(int i = 0;i<4;i++) {
            arr[idx++] = a[i];
        }
        for(int i = 0;i<4;i++) {
            arr[idx++] = b[i];
        }

        return arr;
    }
    public static void print(int[] arr) {
        System.out.print("[ ");
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr1 = new int[4];
        int[] arr2 = new int[4];

        for(int i=0;i<4;i++)
            arr1[i] = scanner.nextInt();
        for(int i=0;i<4;i++)
            arr2[i] = scanner.nextInt();
        int[] arr3 = ArrayUtil.concat(arr1, arr2);

        ArrayUtil.print(arr3);

        scanner.close();
    }

}
