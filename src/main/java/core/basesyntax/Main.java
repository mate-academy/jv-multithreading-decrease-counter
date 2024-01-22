package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        for (int i = 1; i <= 20; i++) {
            new MyThread(counter, String.valueOf(i)).start();
        }
    }
}
