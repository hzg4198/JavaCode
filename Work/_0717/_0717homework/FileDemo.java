package _0717homework;

import java.io.File;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.*;
import java.util.function.Consumer;

public class FileDemo {
    public static void main(String[] args) {
        File f = new File("D:\\SteamLibrary");
        Map<String , List<String>> map = new HashMap<>();
        getFile(f,map);
        map.forEach((o1,o2)->{if (o2.size()!=0){System.out.println(o1+":"+o2.size()+"个,文件名："+o2);}});//打印文件
    }

    public static void getFile(File file,Map<String , List<String>> map){
        File[] files;
        if(file.canRead()) {//判断文件读取权限，不能读则返回
            files = file.listFiles();//获取当前文件目录下的每个文件
        }else return;
//        File[] files = file.listFiles();
        if(files != null){
            for (File file1 : files) {
                if(file1.isFile()){//是文件类型则添加到map中
                    String[] split = file1.getName().split("\\.");
                    int len = split.length;
                    String name;
                    String type;
                    if (len == 2 ) {
                        name = split[0];
                        type = split[1];
                    }else continue;
                    if (map.containsKey(type)){//key为String类型，存取文件类型type
                        map.get(type).add(name);//value为List<String>，存取该文件类型的文件名name
                    }else map.put(type,new ArrayList<>());

                }else getFile(file1,map);
            }
        }
    }
}
