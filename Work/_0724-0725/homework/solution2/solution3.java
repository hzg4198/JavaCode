package homework.solution2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

public class solution3 {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        new Thread(() -> {
            try {
                fizzBuzz.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                fizzBuzz.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                fizzBuzz.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                fizzBuzz.number(System.out::println);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    private static class FizzBuzz {
        private int n;
        private int i = 1;
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz". 被3整除
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (i <= n){
                lock.lock();
                if(i % 3 == 0 && i % 5 !=0){
                    printFizz.run();
                    i++;
                    condition.signalAll();
                }else condition.await();
                lock.unlock();
            }
        }

        // printBuzz.run() outputs "buzz". 被5 整除
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (i <= n){
                lock.lock();
                if (i % 5 == 0 && i % 3 != 0) {
                    printBuzz.run();
                    i++;
                    condition.signalAll();
                }else condition.await();
                lock.unlock();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz". 同时被3和5整除
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (i <= n){
                lock.lock();
                if(i % 3 == 0 && i % 5 == 0){
                    printFizzBuzz.run();
                    i++;
                    condition.signalAll();

                }else condition.await();
                lock.unlock();

            }
        }

        // printNumber.accept(x) outputs "x"
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (i <= n){
                lock.lock();
                if(i % 3 != 0 && i % 5 !=0){
                    printNumber.accept(i);
                    i++;
                    condition.signalAll();
                }else condition.await();
                lock.unlock();
            }
        }
    }
}
