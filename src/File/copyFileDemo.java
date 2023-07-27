package File;

import java.io.*;

public class copyFileDemo {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("C:\\Users\\dengmou\\Pictures\\test.png");
        OutputStream outputStream = new FileOutputStream("testPicture.png");


        byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer)) != -1){
            outputStream.write(buffer,0,len);

        }

        outputStream.close();
        inputStream.close();

        System.out.println("copy end");
    }
}
