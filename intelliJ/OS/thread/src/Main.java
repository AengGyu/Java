public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1 running " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2 running " + i);
            }
        });

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 3 running " + i);
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join(); // main 스레드가 thread1 종료를 기다림
            thread2.join(); // main 스레드가 thread2 종료를 기다림
            thread3.join(); // main 스레드가 thread3 종료를 기다림
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println("All threads have finished");
    }
}