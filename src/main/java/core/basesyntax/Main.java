package core.basesyntax;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(20);
        List<Thread> threadList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            threadList.add(new MyThread(counter, String.valueOf(i)));
            threadList.get(i - 1).start();
            threadList.get(i - 1).join();
        }
    }
}
