package core.basesyntax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Counter {
    private static final Logger logger = LogManager.getLogger(Counter.class);
    private static final String MESSAGE = "%20s, Thread # %2s, counter value %2d";
    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public synchronized void decreaseValue() {
        System.out.println("Before decrementing, Thread # "
                + Thread.currentThread().getName() + ", counter value " + value);

        value--;

        System.out.println("After decrementing, Thread # "
                + Thread.currentThread().getName() + ", counter value " + value);
    }
}
