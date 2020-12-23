package lesson_3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeCount {
    static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    lock.lock();
                    count++;
                    lock.unlock();
                }
                System.out.println("Thread stopped " + finalI);
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(count);
    }
}
