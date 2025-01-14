package insertionSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        int i, j;
        for (i = 1; i < arr.length; i++) {
            int save = arr[i];

            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > save) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = save;
        }
        for (int n : arr) {
            System.out.print(" " + n);
        }
    }
}
