package classDemo;

import java.io.*;
//复制文件
public class Demo7 {
    public static void main(String[] args) throws IOException {
        File scrFile = new File("d:\\Test\\基本查询.txt");
        File destFile = new File("copyTest.txt");

        FileInputStream fileInputStream = new FileInputStream(scrFile);
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);

        int ch = 0;
        while ((ch=fileInputStream.read())!= -1){
            fileOutputStream.write(ch);
        }


    }
}
