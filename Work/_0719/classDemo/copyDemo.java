package classDemo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class copyDemo {
    public static void main(String[] args) throws IOException {
        method1("d:\\test.mkv","copy1.mkv");
        method2("d:\\test.mkv","copy1.mkv");
    }

    private static void method2(String s, String s1) throws IOException {
        InputStream inputStream = Files.newInputStream(Paths.get(s));
        OutputStream outputStream = Files.newOutputStream(Paths.get(s1));
        byte[] b = new byte[1024];
        int len;
        while((len = inputStream.read(b)) != -1){
            outputStream.write(b,0,len);
        }
        inputStream.close();
        outputStream.close();
    }

    private static void method1(String s, String s1) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get(s)));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get(s1)));
        byte[] b = new byte[1024];
        int len;
        while((len = bufferedInputStream.read(b))!=-1){
            bufferedOutputStream.write(b,0,len);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
