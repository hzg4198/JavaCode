package homework.solution1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();
        new Thread(()->{
            Cook cookMaster = new Cook(baoZi, "cook master");
            cookMaster.start();
        }).start();
        new Thread(()->{
            Diner gormandizer = new Diner(baoZi, "Gormandizer");
            gormandizer.start();
        }).start();
    }

     static class Diner extends Thread {
        private BaoZi baoZi;

        public Diner(BaoZi baoZi , String name){
            super(name);
            this.baoZi = baoZi;
        }
        @Override
        public synchronized void run() {
            while (true){
                baoZi.get();
            }

        }
    }

     static class Cook extends Thread {
        private BaoZi baoZi;

        public Cook(BaoZi baoZi ,String name){
            super(name);
            this.baoZi = baoZi;
        }
        @Override
        public synchronized void run() {
            while (true){
                baoZi.add(new BaoZi());
            }
        }
    }

    static class BaoZi {
        private String name;
        static int num = 0;//记录现在的包子
        public List<BaoZi> list = new ArrayList<>();
        public synchronized void add(BaoZi baoZi){
            while (true){
                if(num == 5){
                    try {
                        this.wait();//挂起
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    while (num!=5) {
                        list.add(baoZi);
                        num++;
                        System.out.println(Thread.currentThread().getName()+"做了一个包子");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        this.notify();
                    }
                    break;
                }
            }
        }
        public synchronized void get(){
            while (true){
                if(num < 5){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    while (!list.isEmpty()){
                        list.remove(--num);
                        System.out.println(Thread.currentThread().getName()+"吃掉了一个包子");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    this.notify();
                    break;
                }
            }

        }
    }
}
