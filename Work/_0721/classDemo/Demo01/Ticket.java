package classDemo.Demo01;


public class Ticket implements Runnable {
    int ticker = 100;
    @Override
    public void run() {
        //模拟买票
        while(true){
            if(ticker>0){
                //模拟选座的操作
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"正在买票"+ticker--);
            }
        }
    }
}
