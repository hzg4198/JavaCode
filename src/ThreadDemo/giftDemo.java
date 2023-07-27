package ThreadDemo;

import java.util.ArrayList;

public class giftDemo {
    //100份礼品，小明小红同时发送，少于10份时停止，打印各自送出多少
    static class Gift{
        private String name;
        static ArrayList<Gift> list = new ArrayList<>();
        static {
            for (int i = 0; i < 100; i++) {
                list.add(new Gift());
            }
        }
        void send(){
            synchronized (this) {
                while (list.size() > 10){
                    list.remove(0);
                    System.out.println(Thread.currentThread().getName()+"送出一份礼物,还剩"+list.size()+"个礼物");
                }
            }
        }
    }
    public static void main(String[] args) {
        Gift gift = new Gift();
        new Thread(gift::send,"小明").start();
        new Thread(gift::send,"小红").start();
    }
}
