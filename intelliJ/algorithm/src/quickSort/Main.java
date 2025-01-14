package quickSort;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        quickSort(arr, 0, n - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int pivotIndex = findPivot(arr, left, right);
        int a = partition(arr, left, right, pivotIndex);

        quickSort(arr, left, a - 1);
        quickSort(arr, a + 1, right);
    }

    private static int findPivot(int[] arr, int left, int right) {
        Random random = new Random();

        int idx1 = left + random.nextInt(right - left + 1);
        int idx2 = left + random.nextInt(right - left + 1);
        int idx3 = left + random.nextInt(right - left + 1);

        int n1 = arr[idx1];
        int n2 = arr[idx2];
        int n3 = arr[idx3];

        if ((n1 >= n2 && n1 <= n3) || (n1 <= n2 && n1 >= n3)) {
            return idx1;
        } else if ((n2 >= n1 && n2 <= n3) || (n2 <= n1 && n2 >= n3)) {
            return idx2;
        } else {
            return idx3;
        }
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, right, pivotIndex);

        int a = left;
        int b = right - 1;

        while (a <= b) {
            if (arr[a] < pivot) {
                a++;
            } else if (arr[b] > pivot) {
                b--;
            } else {
                swap(arr, a++, b--);
            }
        }

        swap(arr, a, right);
        return a;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
