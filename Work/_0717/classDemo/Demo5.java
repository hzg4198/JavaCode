package classDemo;

import java.io.File;
import java.io.IOException;

public class Demo5 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\file.txt");

        boolean createNewFile = file.createNewFile();
        System.out.println(createNewFile);

        boolean delete = file.delete();
        boolean exists = file.exists();

        //对目录操作 创建 删除 判断
        System.out.println("----------------");
        File dir = new File("d:\\abc");
        boolean mkdir = dir.mkdir();
        System.out.println(mkdir);
        //删除目录，如果目录中有内容，无法直接删除
//        boolean delete1 = dir.delete();
//        System.out.println(delete1);
        System.out.println(dir.isFile());
        System.out.println(dir.isDirectory());
    }
}
