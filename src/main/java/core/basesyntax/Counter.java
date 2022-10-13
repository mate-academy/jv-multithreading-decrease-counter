package core.basesyntax;

import java.util.concurrent.Semaphore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private static final Logger logger = LogManager.getLogger(Counter.class);
    private static final String MESSAGE = "%20s, Thread # %2s, counter value %2d";
    private int value;
    private final Semaphore semaphore;

    public Counter(int value, Semaphore semaphore) {
        this.value = value;
        this.semaphore = semaphore;
    }

    public void decreaseValue() {
        try {
            semaphore.acquire();
            logger.info(String.format(MESSAGE,
                    "Before decrementing", Thread.currentThread().getName(), value));
            value--;
            logger.info(String.format(MESSAGE,
                    "After decrementing", Thread.currentThread().getName(), value));
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException("Something went wrong!", e);
        }
    }
}
