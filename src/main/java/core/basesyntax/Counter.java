package core.basesyntax;

import java.util.concurrent.locks.ReentrantLock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private static final Logger logger = LogManager.getLogger(Counter.class);
    private static final String MESSAGE = "%20s, Thread # %2s, counter value %2d";
    private int value;
    private final ReentrantLock lock = new ReentrantLock();

    public Counter(int value) {
        this.value = value;
    }

    public synchronized void decreaseValue() {
        lock.lock();
        try {
            logger.info(String.format(MESSAGE,
                    "Before decrementing", Thread.currentThread().getName(), value));
            value--;
            logger.info(String.format(MESSAGE,
                    "After decrementing", Thread.currentThread().getName(), value));
        } finally {
            lock.unlock();
        }
    }
}
