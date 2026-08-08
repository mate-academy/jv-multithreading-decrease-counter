package core.basesyntax;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(new AtomicInteger(20));
        for (int i = 1; i <= 20; i++) {
            new MyThread(counter, String.valueOf(i)).start();
        }
    }
}
