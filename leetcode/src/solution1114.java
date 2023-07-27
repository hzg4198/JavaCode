import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//按序打印
public class solution1114 {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new Thread(()-> {
            try {
                foo.second(()-> System.out.print("second"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                foo.first(()-> System.out.print("first"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()-> {
            try {
                foo.third(()-> System.out.print("third"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
    static class Foo {
        private static final Lock lock =new ReentrantLock();
        private static final Condition condition = lock.newCondition();
        private static volatile int state = 1;

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            if (state == 1) {//打印完3才打印1
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                state = 2;
                condition.signalAll();
            }else condition.await();
            lock.unlock();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            lock.lock();
            if(state == 2) {
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                state = 3;
                condition.signalAll();
            }else condition.await();
            lock.unlock();
        }

        public void third(Runnable printThird) throws InterruptedException {
            lock.lock();
            if(state == 3) {
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                state = 1;
                condition.signalAll();
            }else condition.await();
            lock.unlock();
        }
    }
}
