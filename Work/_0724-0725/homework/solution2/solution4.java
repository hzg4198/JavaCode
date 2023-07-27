package homework.solution2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//5.	写两个线程，一个线程打印1~ 52，另一个线程打印A~Z，打印顺序是12A34B…5152Z
public class solution4 {
    public static void main(String[] args) {
        new Thread(Function::NumThread).start();
        new Thread(Function::LetterThread).start();

    }

    private static class Function{
        private static int count = 1;
        private static char letter = 'A';
        private static final Lock lock = new ReentrantLock();
        private static final Condition condition = lock.newCondition();
        private static boolean flag = true;//设置标记变量 true表示字母打印过了 false表示数字刚打印过了

        public static void NumThread()  {//控制数字打印
            lock.lock();
            while (count <= 52){
                if (flag){//flag == true 表示可以打印数字
                    System.out.print(count++);
                    System.out.print(count++);
                    //数字打印完了 可以打印字母 唤醒其他线程
                    condition.signalAll();//打印结束唤醒其他线程
                    flag = !flag;//改变标记量
                }else {//flag == false 表示还没打印字母 先挂起此线程 等待字母打印
                    try {
                        condition.await();//挂起
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            lock.unlock();
        }

        public static void LetterThread()  {//控制英文打印
            lock.lock();
            while (true){
                if(!flag){// flag = false 表示数字刚打印过 该打印字母了
                    System.out.print(letter++);
                    condition.signalAll();//打印结束唤醒其他线程
                    flag = !flag;//改变标记量
                }else {
                    try {
                        condition.await();//挂起
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(letter > 'Z')break;//退出条件
            }
            lock.unlock();
        }
    }
}
