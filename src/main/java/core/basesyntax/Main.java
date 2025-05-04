package core.basesyntax;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(20);
        for (int i = 1; i <= 20; i++) {
            Thread thread = new MyThread(counter, String.valueOf(i));
            thread.start();
            thread.join();
        }
    }
}
