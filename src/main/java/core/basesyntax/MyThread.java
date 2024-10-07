package core.basesyntax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread extends Thread {
    private static final Logger logger = LogManager.getLogger(MyThread.class);
    private final Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.decrement();
    }
}
