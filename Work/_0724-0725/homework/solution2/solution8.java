package homework.solution2;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
public class solution8 {
	public static void main(String[] args) {
		ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(9);
		new Thread(()->{
			try {
				zeroEvenOdd.even(System.out::print);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}).start();
		new Thread(()->{
			try {
				zeroEvenOdd.odd(System.out::print);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}).start();
		new Thread(()->{
			try {
				zeroEvenOdd.zero(System.out::print);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}).start();
	}
	static class ZeroEvenOdd {
		private final int n;
		private int i = 1;//记录现在打印到几了
		private final Lock lock = new ReentrantLock();
		private final Condition condition = lock.newCondition();
		private boolean flag = true;//设置标记记录是否打印了奇偶数 false为没有 因为一开始要打印0
		public ZeroEvenOdd(int n) {
			this.n = n;
		}
		public void zero(IntConsumer printNumber) throws InterruptedException {
			lock.lock();
			while (i <= n){
				if(flag){//flag == true 表示该打印0了
					printNumber.accept(0);
//					i++;
					flag = !flag;//打印过后改变标记量
					condition.signalAll();//打印过后唤醒其他线程
				}else {//还不该打印0 挂起
					condition.await();
				}
			}
			lock.unlock();
		}
		public void even(IntConsumer printNumber) throws InterruptedException {
			lock.lock();
			while (i <= n){
				if (!flag && i % 2 == 0){//flag == false 打印奇偶数
					printNumber.accept(i++);
					flag = !flag;//打印过后改变标记量
					condition.signalAll();//唤醒其他线程
				}else {//挂起等待
					condition.await();
				}
			}
			lock.unlock();
		}
		public void odd(IntConsumer printNumber) throws InterruptedException {
			lock.lock();
			while (i <= n){//同上道理
				if (!flag && i % 2 == 1){
					printNumber.accept(i++);
					flag = !flag;
					condition.signalAll();
				}else {
					condition.await();
				}
			}
			lock.unlock();
		}
	}
}
