package collection.deque.test.queue;

public class BackUpTask implements Task{
    @Override
    public void execute() {
        System.out.println("자료 백업...");
    }
}
