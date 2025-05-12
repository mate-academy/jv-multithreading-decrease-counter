package core.basesyntax;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(20);
        Thread a;
        for (int i = 1; i <= 20; i++) {
            a = new MyThread(counter, String.valueOf(i));
            a.start();
            a.join();
        }
    }
}
