package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(20);

        Runnable task = counter::decreaseValue;

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(task, String.valueOf(i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}
