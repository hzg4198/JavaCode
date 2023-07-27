package classDemo;

public class ThreadDemo02 {
    public static void main(String[] args) throws InterruptedException {
        //休眠
        /*System.out.println("111111");
        Thread.sleep(5000);
        System.out.println("2222");*/
        //设置线程的优先级
        MyRunable myRunable = new MyRunable();
        Thread a = new Thread(myRunable, "A");
        Thread b = new Thread(myRunable, "B");
        a.start();
        a.setPriority(10);//设置a的优先级
        b.start();
        //获取线程的优先级
//        System.out.println(a.getPriority());
//        System.out.println(b.getPriority());
//        System.out.println(Thread.currentThread().getPriority());


    }
}
