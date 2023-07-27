package classDemo;

public class ThreadDemo04 {
    public static void main(String[] args) {
        MyRunable myRunable = new MyRunable();
        Thread a = new Thread(myRunable, "A");
        Thread b = new Thread(myRunable, "B");
        //yield 礼让线程

    }
}
