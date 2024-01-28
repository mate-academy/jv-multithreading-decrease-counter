package core.basesyntax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private static final Logger logger = LogManager.getLogger(Counter.class);
    private static final String MESSAGE = "%20s, Thread # %2s, counter value %2d";
//    private int value;
    private AtomicInteger value = new AtomicInteger(0);

    public Counter(int value) {
        this.value.set(value);
    }

    public void decreaseValue() {
        logger.info(String.format(MESSAGE,
                "Before decrementing", Thread.currentThread().getName(), value.get()));
        value.decrementAndGet();
        logger.info(String.format(MESSAGE,
                "After decrementing", Thread.currentThread().getName(), value.get()));
    }
}
