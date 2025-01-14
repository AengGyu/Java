package selectionSort;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[scanner.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = arr.length - 1; i > 0; i--) {
            int maxIdx = 0;

            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }

            int tmp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = tmp;
        }

        for (int n : arr) {
            System.out.print(n + " ");
        }
    }
}
