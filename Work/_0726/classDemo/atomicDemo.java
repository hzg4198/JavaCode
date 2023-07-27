package _0726.classDemo;

import java.util.concurrent.atomic.AtomicInteger;

//原子包
public class atomicDemo {
    public static void main(String[] args) {
        //初始化一个默认值为0的原子性Integer
        AtomicInteger a = new AtomicInteger();
        System.out.println(a);
        System.out.println(a.get());
        //以原子的方式加一，得到自增之前的值
        int andIncrement = a.getAndIncrement();
        System.out.println(a);
        //原子方式加一，得到自增之后的值
        int incrementAndGet = a.incrementAndGet();
        System.out.println(a);
        System.out.println(andIncrement+" "+incrementAndGet);
    }

}
