package core.basesyntax;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {
    private final Counter counter;
    private final Semaphore semaphore;

    public MyThread(Counter counter, String name, Semaphore semaphore) {
        super(name);
        this.counter = counter;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        counter.decreaseValue();
        semaphore.release();
    }
}
