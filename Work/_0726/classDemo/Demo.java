package _0726.classDemo;
//车站只剩 50 张从武汉到北京的车票，现有 3 个窗口售卖，用程序模拟售票的过程，要求使用同步方法保证售票过程中票数的正确性
public class Demo {
    static class Window extends Thread{
        static {ticket = 50;}
        private  static int ticket;

        public Window(){}

        @Override
        public  void run() {
            while(ticket > 0){
                synchronized (this) {
                    String name = Thread.currentThread().getName();
                    System.out.println(name+"售出了一张票,还剩"+ticket+"张票");
                    ticket--;
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) {
        Window window = new Window();
        new Thread(window,"窗口二").start();
        new Thread(window,"窗口三").start();
        new Thread(window,"窗口一").start();
    }
}
