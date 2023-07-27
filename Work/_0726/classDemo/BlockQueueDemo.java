package _0726.classDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueueDemo {
    static class Cooker extends Thread{
        private ArrayBlockingQueue<String> queue;

        public Cooker(ArrayBlockingQueue<String> queue){
            super();
            this.queue=queue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    queue.put("包子");
                    System.out.println("做了一个包子");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    static class Diner extends Thread{
        private ArrayBlockingQueue<String> queue;

        public Diner(ArrayBlockingQueue<String> queue){
            super();
            this.queue=queue;
        }

        @Override
        public void run() {
            while (true){
                try {
                    String take = queue.take();
                    System.out.println("吃了一个"+take);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(1);
        Cooker cooker = new Cooker(queue);
        Diner diner = new Diner(queue);

        diner.start();
        cooker.start();

    }
}
