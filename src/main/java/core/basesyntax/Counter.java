package core.basesyntax;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private static final Logger logger = LogManager.getLogger(Counter.class);
    private static final String MESSAGE = "%20s, Thread # %2s, counter value %2d";
    private AtomicInteger value;

    public Counter(int value) {
        this.value = new AtomicInteger(value);
    }

    public void decreaseValue() {
        logger.info(String.format(MESSAGE,
                "Before decrementing", Thread.currentThread().getName(), value.get()));
        value.getAndDecrement();
        logger.info(String.format(MESSAGE,
                "After decrementing", Thread.currentThread().getName(), value.get()));
    }
}
