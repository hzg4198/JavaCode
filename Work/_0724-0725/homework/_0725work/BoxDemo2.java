package homework._0725work;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoxDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,100,20,50,200,5000,500,1000,2000);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Box box1 = new Box(list,"抽奖箱一");
        Box box2 = new Box(list,"抽奖箱二");

        Future<Integer> rs1 = executorService.submit(box1);
        Future<Integer> rs2 = executorService.submit(box2);
        executorService.shutdown();
        Box max = rs1.get() > rs2.get() ? box1 : box2;
        System.out.println(max.name+"抽中的金额最多："+Math.max(rs1.get(), rs2.get()));
    }

    static class Box implements Callable<Integer>{
        private  static ArrayList<Integer> list = new ArrayList<>();
        private  String name;
        public static final Object object = new Object();


        public Box(ArrayList<Integer> list,String name){
            Box.list = list;
            this.name = name;
        }
        @Override
        public Integer call() throws Exception {
            synchronized (object) {
                  int total = 0;
                while (!list.isEmpty()) {
                    Collections.shuffle(list);
                    Integer price = list.remove(0);
                    System.out.println(this.name + "抽中了" + price + "元大奖");
                    total += price;
//                    try {
//                        Thread.sleep(300);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    object.wait(300);
                }
                return total;
            }
        }
    }
}
