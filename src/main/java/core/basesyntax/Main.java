package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger MAX = new AtomicInteger(20);

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(MAX);
        List<MyThread> threads = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            threads.add(new MyThread(counter, String.valueOf(i)));
        }

        for (MyThread thread : threads) {
            thread.start();
        }

        for (MyThread thread : threads) {
            thread.join();
        }
    }
}
