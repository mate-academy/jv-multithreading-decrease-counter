package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(20);
        Thread[] threads = new Thread[20];
        for (int i = 0; i <= threads.length - 1; i++) {
            threads[i] = new MyThread(counter, String.valueOf(i));
            threads[i].start();
        }
    }
}
