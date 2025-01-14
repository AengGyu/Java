package mergeSort;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        list = mergeSort(list);
        for (Integer data : list) {
            System.out.print(" " + data);
        }
    }

    private static List<Integer> mergeSort(List<Integer> list){
        if(list.size() <= 1) return list;

        List<Integer> L1 = new LinkedList<>();
        List<Integer> L2 = new LinkedList<>();
        partition(list, L1,L2);

        L1 = mergeSort(L1);
        L2 = mergeSort(L2);

        return merge(L1,L2);
    }

    private static void partition(List<Integer> list, List<Integer> L1, List<Integer> L2) {
        int mid = list.size() / 2;
        int idx = 0;
        for (Integer i : list) {
            if(idx < mid) L1.add(i);
            else L2.add(i);
            idx++;
        }
    }

    private static List<Integer> merge(List<Integer> L1, List<Integer> L2) {
        List<Integer> merge = new LinkedList<>();

        while(!L1.isEmpty() && !L2.isEmpty()){
            if(L1.get(0) <= L2.get(0)){
                merge.add(L1.remove(0));
            }else{
                merge.add(L2.remove(0));
            }
        }
        if(!L1.isEmpty()) merge.addAll(L1);
        if(!L2.isEmpty()) merge.addAll(L2);

        return merge;
    }
}
