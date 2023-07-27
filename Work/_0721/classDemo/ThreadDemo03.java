package classDemo;

public class ThreadDemo03 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("zi");
            }
        });
//        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("zhu");
        }
        System.out.println("zhu out");
    }
}
