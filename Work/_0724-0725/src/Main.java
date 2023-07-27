import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Date startDate = new Date(System.currentTimeMillis());

        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startDate));
            startDate = new Date(System.currentTimeMillis());
        }
    }
}