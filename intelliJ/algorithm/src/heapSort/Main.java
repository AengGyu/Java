package heapSort;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Heap heap = new Heap(scanner.nextInt());
        heap.insertHeap();
        heap.heapSort();
        heap.printAll();
    }

    static class Heap {
        int size;
        int[] heap;

        public Heap(int size) {
            this.size = size;
            heap = new int[size + 1];
        }

        public void downHeap(int idx) {
            int childIdx = getHighPriorityIndex(idx);

            if (childIdx == 0) return;
            if (heap[idx] >= heap[childIdx]) return;

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

        public void heapSort() {
            int originalSize = size;
            for (int i = size; i > 1; i--) {
                int tmp = heap[1];
                heap[1] = heap[i];
                heap[i] = tmp;

                size--;
                downHeap(1);
            }
            size = originalSize;
            printAll();
            buildHeap(1);
        }

        public void printAll() {
            for (int i = 1; i <= size; i++) {
                System.out.print(" " + heap[i]);
            }
            System.out.println();
        }
    }
}

