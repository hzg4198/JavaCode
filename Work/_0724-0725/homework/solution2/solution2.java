package homework.solution2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class solution2 {
    public static void main(String[] args) {
        Function function = new Function();
        int count  = 0;
        while (count++ < 3) {
            new Thread(function::MainFunction).start();
            new Thread(function::SubFunction).start();
        }
    }
    private static class Function{
        private final Lock lock = new ReentrantLock();//获得锁对象
        private final Condition condition = lock.newCondition();//获得condition对象
        //判断子线程是否执行了，未执行则主线程挂起，先让子线程执行
        boolean flag = false;//false 表示子线程未执行
        public void MainFunction(){
            try {
                lock.lock();
                while (true){//一次执行
                    if(!flag){//flag = false
                        condition.await();//挂起等待子线程
                    }else {//flag = true
                        for (int i = 0; i < 5; i++) {//主线程执行五次
                            System.out.println("主线程执行了");
                            Thread.sleep(500);
                        }
                        condition.signal();
                        flag = !flag;
//                        condition.await();
                        break;
                    }

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }

        public void SubFunction(){
            try {
                lock.lock();
                while (true){
                    if(flag){
                        try {
//                            condition.signal();
                            condition.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }else {
                        for (int i = 0; i < 3; i++) {//子线程执行三次
                            System.out.println("子线程执行了");
                            Thread.sleep(500);
                        }

                        condition.signal();
                        flag = !flag;
                        break;
                    }
                }
            } catch (RuntimeException | InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }
}
