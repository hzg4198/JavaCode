package classDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
     /*   MyThread myThread = new MyThread("新的线程");
        myThread.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println("main:"+i);
        }
*/
//        MyRunable myRunable = new MyRunable();
//        Thread t = new Thread(myRunable);
//        t.start();
       /* MyCallable myCallable = new MyCallable();
        //创建FutureTask对象 管理多线程运行的结果
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        //创建线程对线
        Thread thread = new Thread(futureTask);
        thread.start();
        //获取多线程的运行结果
        Integer integer = futureTask.get();
        System.out.println(integer);
*/
        System.out.println("--------匿名内部类的方式------------");
        new Thread(() -> System.out.println("create new thread")).start();

        //----------------runnable-------------------

        /*new Thread( new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+i);
                }
            }
        }).start();*/

    }
}