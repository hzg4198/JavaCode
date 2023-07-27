package classDemo;

import java.io.File;

public class Demo4 {
    public static void main(String[] args) {
        //根据字符串表示的路径，变成file对象
        String str = "d:\\基本查询.txt";
        File F1 = new File(str);
        System.out.println(F1);
        //父级路径 子级路径
        String parent = "d:\\";
        String child = "基本查询.txt";
        File f2 = new File(parent,child);
        System.out.println(f2);

        System.out.println("-------常用方法----------");
        System.out.println(f2.length());



    }

}
