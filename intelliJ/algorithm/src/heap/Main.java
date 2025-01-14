package heap;

import java.util.Scanner;
import java.util.StringTokenizer;

// 최대 힙
public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringTokenizer st;
        boolean flag = true;
        Heap heap = new Heap();

        while (flag) {
            st = new StringTokenizer(scanner.nextLine());

            switch (st.nextToken()) {
                case "i":
                    int key = Integer.parseInt(st.nextToken());
                    heap.insertHeap(key);
                    sb.append('0').append('\n');
                    break;
                case "d":
                    sb.append(heap.deleteHeap()).append('\n');
                    break;
                case "p":
                    heap.printAll();
                    break;
                case "q":
                    flag = false;
                    break;
            }
        }
        System.out.println(sb);
    }

    static class Heap {
        int size;
        int[] heap;

        public Heap() {
            this.heap = new int[101];
            this.size = 0;
        }

        public void insertHeap(int key) {
            if (size + 1 > 100) return;

            heap[++size] = key;
            upHeap(size);
        }

        public void upHeap(int idx) {
            if (idx == 1) return; // 첫번째 원소인 경우 아무것도 하지 않음
            if (heap[idx] <= heap[idx / 2]) return; // 최대 힙이므로 부모의 값보다 작으면 리턴
            int tmp = heap[idx];
            heap[idx] = heap[idx / 2];
            heap[idx / 2] = tmp;
            upHeap(idx / 2);
        }

        public int deleteHeap() {
            int del = heap[1];

            heap[1] = heap[size];
            downHeap(1);
            size--;
            return del;
        }

        public void downHeap(int idx) {
            int childIdx = getHighPriorityIndex(idx);

            if (childIdx == 0) return; // 자식이 없으면 return
            if (heap[idx] >= heap[childIdx]) return; // 자식의 값보다 크면 return

            int tmp = heap[idx];
            heap[idx] = heap[childIdx];
            heap[childIdx] = tmp;

            downHeap(childIdx);
        }

        public int getHighPriorityIndex(int idx) {
            if (idx * 2 > size) return 0;
            if (idx * 2 == size) return idx * 2;
            else return heap[idx * 2] > heap[idx * 2 + 1] ? idx * 2 : idx * 2 + 1;
        }

        public void printAll() {
            for (int i = 1; i <= size; i++) {
                sb.append(' ').append(heap[i]);
            }
            sb.append('\n');
        }
    }
}
