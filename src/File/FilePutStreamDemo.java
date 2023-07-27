package File;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePutStreamDemo {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("Test.txt");
//        //读取文件中的字节数据，每次读取多个字符
//        byte[] buffer = new byte[900];
//
//        int read = is.read(buffer);
//        String s = new String(buffer);
//        System.out.println(s);
//        OutputStream fileOutputStream = new FileOutputStream("Test.txt");
//        fileOutputStream.write(97);
//        fileOutputStream.write(98);
//        fileOutputStream.write(99);
//        fileOutputStream.write(51);
//        fileOutputStream.write(51);
        byte[] buffer = new byte[6];
        int len;
        while ((len = is.read(buffer)) != -1){
            String s = new String(buffer, 0, len);
            System.out.print(s);
        }
        Files.readAllBytes(Paths.get("Test.txt"));


    }
}
