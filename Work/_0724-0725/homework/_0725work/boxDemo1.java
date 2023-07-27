package homework._0725work;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class boxDemo1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,100,20,50,200,5000,500,1000,2000);
        Box box = new Box(list);
        new Thread(box,"box1").start();
        new Thread(box,"box2").start();

    }
    static class Box implements Runnable{
        private static ArrayList<Integer> list = new ArrayList<>();
        private final Lock lock = new ReentrantLock();
        private final Condition condition = lock.newCondition();

        public Box(ArrayList<Integer> list){
            Box.list = list;
        }
        @Override
        public void run() {
            int total = 0;
            int max = -1;
            lock.lock();
            while (!list.isEmpty()){
                Collections.shuffle(list);
                Integer price = list.remove(0);
                System.out.println(Thread.currentThread().getName()+ "抽中了" + price +"元大奖");
                total += price;
                if(price > max) max = price;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                condition.signalAll();
                try {
                    if(!list.isEmpty())condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + "一共抽中了" + total+"元,最多金额为"+ max);
            lock.unlock();
        }
    }
}