package core.basesyntax;

public class Main {
    private static final int MAX_VALUE = 20;

    public static void main(String[] args) {
        Counter counter = new Counter(MAX_VALUE);
        for (int i = 1; i <= MAX_VALUE; i++) {
            new MyThread(counter, String.valueOf(i)).start();
        }
    }
}
