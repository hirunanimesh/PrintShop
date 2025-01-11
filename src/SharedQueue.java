import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {
    private final Queue<PrintJob> queue = new LinkedList<>();
    private final int capacity = 5;

    public synchronized void add(PrintJob job) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(job);
        notifyAll();
    }

    public synchronized PrintJob remove() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        PrintJob job = queue.remove();
        notifyAll();
        return job;
    }  
}
