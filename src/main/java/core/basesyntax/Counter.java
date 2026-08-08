package core.basesyntax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private static final Logger logger = LogManager.getLogger(Counter.class);
    private int count;

    public Counter(int initialCount) {
        this.count = initialCount;
    }

    public synchronized void decrement() {
        logger.info("Before decrementing, Thread #" + Thread.currentThread().getId()
                + ", counter value " + count);
        count--;
        logger.info("After decrementing, Thread #" + Thread.currentThread().getId()
                + ", counter value " + count);
    }
}
