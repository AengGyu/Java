package class2.q1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            if(binarySearch(arr, Integer.parseInt(st.nextToken()), 0, arr.length-1)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }

    static boolean binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return false;

        int mid = (start + end) / 2;

        if (arr[mid] == target) return true;
        else if (arr[mid] < target) return binarySearch(arr, target, mid + 1, end);
        else return binarySearch(arr, target, start, mid - 1);
    }
}
