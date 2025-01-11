public class Computer extends Thread {
    private final SharedQueue queue;

    public Computer(SharedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            String content = FileUtil.readFileContent("E:\\My Downloads\\PrintShop\\New Text Document.txt");
            if (content != null) {
                PrintJob job = new PrintJob(content);
                queue.add(job);
                System.out.println("Computer added a job: " + content);
            } else {
                throw new TypeNotSupportedException("Unsupported file content.");
            }
        } catch (InterruptedException | TypeNotSupportedException e) {
            e.printStackTrace();
        }
    }
}