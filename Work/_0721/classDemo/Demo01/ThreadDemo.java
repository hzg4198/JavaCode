package classDemo.Demo01;

public class ThreadDemo {
    public static void main(String[] args) {
        Ticker t1 = new Ticker();
        Ticker t2 = new Ticker();
        Ticker t3 = new Ticker();
        Thread thread1 = new Thread(t1, "手机1");
        Thread thread2 = new Thread(t2, "手机2");
        Thread thread3 = new Thread(t3, "手机3");
        thread1.start();
        thread2.start();
        thread3.start();

    /*    Ticker t1 = new Ticker();
//        Ticker t2 = new Ticker();
//        Ticker t3 = new Ticker();
        Thread thread1 = new Thread(t1, "手机1");
        Thread thread2 = new Thread(t1, "手机2");
        Thread thread3 = new Thread(t1, "手机3");
        thread1.start();
        thread2.start();
        thread3.start();*/
    }
}
