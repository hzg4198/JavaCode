package classDemo;

public class MyThread extends Thread {

    public MyThread(String name){
        super(name);
    }
    public MyThread( ){
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(getName()+"正在执行"+i);
        }
        return null;
    }
}
