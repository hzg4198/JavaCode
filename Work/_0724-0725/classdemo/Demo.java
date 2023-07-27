package classdemo;

public class Demo {
    public static void main(String[] args) {
        new Thread(()->printNum("A")).start();
        new Thread(()->printNum("B")).start();
    }

    private static void printNum(String str){;
        int count  = 0;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while(++count<3) {
            System.out.println(str+" print"+count);
        }
    }
}
