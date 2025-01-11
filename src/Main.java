public class Main {
    public static void main(String[] args) {
        // Create an instance of the shared queue
        SharedQueue sharedQueue = new SharedQueue();
        
        // Initialize and start the Computer threads (producers)
        for (int i = 1; i <= 3; i++) {
            Computer computer = new Computer(sharedQueue);
            computer.start();
        }
        
        // Initialize and start the Printer threads (consumers)
        for (int i = 1; i <= 2; i++) {
            Printer printer = new Printer(sharedQueue);
            printer.start();
        }
    }
}
