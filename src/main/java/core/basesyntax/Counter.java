package core.basesyntax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private static final Logger logger = LogManager.getLogger(Counter.class);

    private int value = 20;

    public synchronized void decrement() {
        logger.info("Before decrementing, Thread # {}, counter value {}",
                Thread.currentThread().getName(), value);

        value--;

        logger.info("After decrementing, Thread # {}, counter value {}",
                Thread.currentThread().getName(), value);
    }
}
