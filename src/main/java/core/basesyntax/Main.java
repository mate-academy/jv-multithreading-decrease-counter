package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(new AtomicInteger(20));
        List<MyThread> threads = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            threads.add(new MyThread(counter, String.valueOf(i)));
        }

        for (MyThread thread : threads) {
            thread.start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
