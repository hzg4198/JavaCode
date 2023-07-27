package ThreadDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class Lock {
    static class MyRunnable implements Runnable{
        private AtomicInteger co = new AtomicInteger();
        @Override
        public  void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(co.incrementAndGet());
            }
        }
    }
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();

        for (int i = 0; i < 100; i++) {
            new Thread(runnable).start();
        }
    }
}
