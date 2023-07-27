package homework.solution2;

import java.util.Random;

//设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。考虑到线程的安全性写出程序。
public class solution7 {
	public static void main(String[] args) {
		Operator operator = new Operator();
		int count = 100;
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				operator.increase();
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				operator.increase();
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				operator.decrease();
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 10; i++) {
				operator.decrease();
			}
		}).start();
	}
	static class Operator{
		static {//使用静态代码块使第一次加载Operator类时 初始化num并打印
			num = new Random().nextInt(100);
			System.out.println("起始数字为num="+Operator.num);
		}
		private static int num;//要操作的数
		static final Object obj = new Object();//使用static修饰obj为类锁
		public Operator(){}
		public Operator(int num){//构造器
			this.num = num;
		}
		public void increase(){
			synchronized (obj){
				num++;
				System.out.println(Thread.currentThread().getName()+"使数字增加1，num="+num);
				try {
					Thread.sleep(1000);
					Thread.yield();//礼让其他线程进行操作
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
		public void decrease(){
			synchronized (obj){
				num--;
				System.out.println(Thread.currentThread().getName()+"使数字减少1，num="+num);
				try {
					Thread.sleep(1000);
					Thread.yield();
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
