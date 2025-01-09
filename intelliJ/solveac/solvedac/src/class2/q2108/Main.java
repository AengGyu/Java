package class2.q2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int avg = getAvg(arr);
        int middle = getMid(arr);
        int freq = getFreq(arr);
        int diff = getDiff(arr);

        System.out.println(avg);
        System.out.println(middle);
        System.out.println(freq);
        System.out.println(diff);
    }

    private static int getAvg(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        double avg = (double) sum / arr.length;
        return (int) (Math.round(avg));
    }

    private static int getMid(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    private static int getFreq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        int maxFreq = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            if (maxFreq < value) {
                maxFreq = value;
                list.clear();
                list.add(key);
            } else if (maxFreq == value) {
                list.add(key);
            }
        }
        Collections.sort(list);
        return list.size() == 1 ? list.get(0) : list.get(1);
    }

    private static int getDiff(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
            if (min > arr[i]) min = arr[i];
        }

        return max - min;
    }
}
