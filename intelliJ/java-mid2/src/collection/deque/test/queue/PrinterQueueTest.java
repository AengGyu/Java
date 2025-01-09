package collection.deque.test.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrinterQueueTest {
    public static void main(String[] args) {
        Queue<String> printerQueue = new ArrayDeque<>();

        printerQueue.offer("doc1");
        printerQueue.offer("doc2");
        printerQueue.offer("doc3");

        System.out.println("출력: " + printerQueue.poll());
        System.out.println("출력: " + printerQueue.poll());
        System.out.println("출력: " + printerQueue.poll());
    }
}
