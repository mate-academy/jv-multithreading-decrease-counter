package core.basesyntax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private static final Logger logger = LogManager.getLogger(Counter.class);
    private static final String MESSAGE = "%20s, Thread # %2s, counter value %2d";

    private int value;

    private Object monitor = new Object();

    public Counter(int value) {
        this.value = value;
    }

    public void decreaseValue() {
        synchronized (monitor) {
            logger.info(String.format(MESSAGE,
                    "Before decrementing", Thread.currentThread().getName(), value));
            try {
                value--;
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                throw new RuntimeException("Cannot lower value" + e);
            }
            logger.info(String.format(MESSAGE,
                    "After decrementing", Thread.currentThread().getName(), value));
        }
    }
}
