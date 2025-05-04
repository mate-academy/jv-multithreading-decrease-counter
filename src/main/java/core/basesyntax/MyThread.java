package core.basesyntax;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {
    private static final Lock L = new ReentrantLock();
    private final Counter counter;

    public MyThread(Counter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
        L.lock();
        counter.decreaseValue();
        L.unlock();
    }
}
