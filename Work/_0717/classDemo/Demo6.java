package classDemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo6 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File("fos.txt"));
        fos.write(97);
        fos.write(98);
        fos.write(99);

        byte[] b = "我爱你中国".getBytes();
        fos.write(b);
    }
}
