package _0726.classDemo;

import java.util.HashMap;

public class hashMapDemo {
    public static void main(String[] args) {
        HashMap<String ,String> map = new HashMap<>();

        new Thread(()->{
            synchronized (map){
                for (int i = 0; i < 25; i++) {
                    map.put(i+"",i+"");
                }
            }}).start();

        new Thread(()->{
            synchronized (map){ for (int i = 25; i < 50; i++) { map.put(i+"",i+"");}}}).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(map.get(i+"")+"");

        }
    }
}
