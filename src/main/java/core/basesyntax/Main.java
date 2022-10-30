package core.basesyntax;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        Counter counter = new Counter(20);
        synchronized (counter) {
            for (int i = 1; i <= 20; i++) {
                new MyThread(counter, String.valueOf(i), semaphore).start();
            }
        }
    }
}
