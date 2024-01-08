package core.basesyntax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private static final Logger logger = LogManager.getLogger(Counter.class);
    private static final String MESSAGE = "%20s, Thread # %2s, counter value %2d";
    private int value;
    private final ReentrantLock lock = new ReentrantLock();

    public Counter(int value) {
        this.value = value;
    }

    public void decreaseValue() {
        lock.lock();
        logger.info(String.format(MESSAGE,
                "Before decrementing", Thread.currentThread().getName(), value));
        try {
            value--;
        } finally {
            lock.unlock();
        }
        logger.info(String.format(MESSAGE,
                "After decrementing", Thread.currentThread().getName(), value));
    }
}
