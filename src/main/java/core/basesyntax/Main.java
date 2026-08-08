package core.basesyntax;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread[] threads = new Thread[20];

        for (int i = 0; i < 20; i++) {
            threads[i] = new MyThread(counter, String.valueOf(i + 1));
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
