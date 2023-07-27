package classdemo;

public class Demo3 {

    public static void main(String[] args) {
        char c = 'A';
        for (int i = 0; i < 5; i++) {
            new Thread(new MyThread(), String.valueOf(c++)).start();
        }
    }
}

