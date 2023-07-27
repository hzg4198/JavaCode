package classdemo;

import java.util.Random;

public class MyThread extends Thread {
    static double money = 100;
    static int count = 3;

    static final double MIN = 0.01;

    @Override
    public void run() {
        synchronized (MyThread.class){
            if(count == 0){
                System.out.println(Thread.currentThread().getName()+"没有抢到红包");
            }else {
                double prize = 0;
                if(count == 1){
                    //最后一个红包
                    prize = money;
                }else {
                    double bounds = money -(count - 1)*MIN;
                    Random r = new Random();
                    prize = r.nextDouble()*bounds;
                    if(prize < MIN) prize = MIN;
                }
                money -= prize;
                count--;
                System.out.println(Thread.currentThread().getName()+"抢到了"+prize);
            }
        }
    }
}
