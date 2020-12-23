package lesson_3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class PingPong {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1, true);
//        Без этого ping пингует много раз подряд, до того как стартует pong.
        AtomicInteger kapellmeister = new AtomicInteger(0);
        AtomicInteger pings = new AtomicInteger();
        AtomicInteger pongs = new AtomicInteger();

        Thread ping = new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    if (kapellmeister.get()==0) {
                        System.out.println("ping");
                        pings.getAndIncrement();
                        kapellmeister.set(1);
                    }
                    semaphore.release();
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        Thread pong = new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    if (kapellmeister.get() == 1) {
                        System.out.println("pong");
                        pongs.getAndIncrement();
                        kapellmeister.set(0);
                    }
                    semaphore.release();
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        ping.start();
        pong.start();
        Thread.sleep(5000);
        ping.interrupt();
        pong.interrupt();
        System.out.println(pings);
        System.out.println(pongs);
    }
}
