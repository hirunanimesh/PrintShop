public class Printer extends Thread {
    private final SharedQueue queue;

    public Printer(SharedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                PrintJob job = queue.remove();
                System.out.println("Printer processing a job: " + job.getContent());
                Thread.sleep(1000); // Simulate processing time
            }
        } catch (InterruptedException e) {
            System.out.println("Printer interrupted.");
        }
    }
}
