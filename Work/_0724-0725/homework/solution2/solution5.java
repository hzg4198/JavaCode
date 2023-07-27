package homework.solution2;

import java.util.concurrent.*;

//编写10个线程，第一个线程从1加到10，第二个线程从11加20…第十个线程从91加到100，最后再把10个线程结果相加。
public class solution5 {

	//创建10个线程 以每个起点数字作为参数

	public static void main(String[] args) throws Exception {
		int totalSum = 0;
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			int k = i * 10 + 1;
			Add add = new Add(k);
			Future<Integer> submit = executorService.submit(add);
			totalSum += submit.get();
		}
		executorService.shutdown();
		System.out.println(totalSum);

	}
	//创建Callable的实现类Add
	static class Add implements Callable<Integer> {
		private int startNum;//起始数字

		public Add(int num){
			this.startNum = num;
		}
		//重写call方法实现加和
		@Override
		public Integer call() throws Exception {
			System.out.println(Thread.currentThread().getName()+"正在计算从"+startNum+"到"+(startNum+9)+"的和");
			Thread.sleep(50);
			int sum = 0;//记录和
			for (int i = 0; i < 10; i++) {
				sum += startNum++;
			}
			return sum;
		}
	}
}



