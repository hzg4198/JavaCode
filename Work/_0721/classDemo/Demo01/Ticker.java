package classDemo.Demo01;


public  class Ticker extends Thread{
    static int ticker = 100;
    Object obj = new Object();
    @Override
    public void run() {
        //模拟买票
        while(true){
                if(ticker>1){
                    //模拟选座的操作
                    synchronized (obj){
                        try {
                            Thread.sleep(0);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(Thread.currentThread().getName()+"正在买票"+ticker--);
                    }

                }else break;
        }
        return null;
    }
}
