package core.basesyntax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private static final Logger LOGGER = LogManager.getLogger(Counter.class);
    private static final String MESSAGE = "%20s, Thread # %2s, counter value %2d";
    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public synchronized void decreaseValue() {
        if (value >= 0) {
            LOGGER.info(String.format(MESSAGE,
                    "Before decrementing", Thread.currentThread().getName(), value));
            value--;
            LOGGER.info(String.format(MESSAGE,
                    "After decrementing", Thread.currentThread().getName(), value));
        }
    }
}
