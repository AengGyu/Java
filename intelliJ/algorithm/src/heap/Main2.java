package heap;

import java.util.Scanner;

// 상향식 힙 생성
public class Main2 {
    static StringBuilder sb = new StringBuilder();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Heap heap = new Heap(scanner.nextInt());
        heap.insertHeap();
        heap.printAll();
    }

    static class Heap {
        int size;
        int[] heap;

        public Heap(int size) {
            this.size = size;
            heap = new int[size + 1];
        }

        public void insertHeap() {
            for (int i = 1; i <= size; i++) {
                heap[i] = scanner.nextInt();
            }
            buildHeap(1);
        }

        public void buildHeap(int idx) {
            if (idx * 2 > size) return;
            buildHeap(idx * 2);
            buildHeap(idx * 2 + 1);
            downHeap(idx);
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
                System.out.print(" " + heap[i]);
            }
            System.out.println();
        }
    }
}
