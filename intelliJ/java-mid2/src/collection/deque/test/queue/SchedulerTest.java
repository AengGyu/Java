package collection.deque.test.queue;

public class SchedulerTest {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        scheduler.addTask(new CompressionTask());
        scheduler.addTask(new BackUpTask());
        scheduler.addTask(new CleanTask());

        System.out.println("작업 시작");
        run(scheduler);
        System.out.println("작업 종료");
    }
    private static void run(TaskScheduler scheduler){
        while(scheduler.getRemainingTasks() > 0){
            scheduler.processNextTask();
        }
    }
}
