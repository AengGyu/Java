package collection.deque.test.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskScheduler {
    private Queue<Task> scheduler = new ArrayDeque<>();

    public void addTask(Task task){
        scheduler.offer(task);
    }

    public void processNextTask() {
        Task task = scheduler.poll();
        if(task != null){
            task.execute();
        }
    }

    public int getRemainingTasks() {
        return scheduler.size();
    }
}
