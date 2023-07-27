package Demo0714;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*创建一个集合 存储多个字符串元素
* 把集合中所有以张开头的元素存储到一个新的集合里面
* 吧张开头的集合中的长度为三的元素存储到一个新的集合
* 遍历上一步得到的集合
* */
public class StreamDemo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张三丰","张无忌","张翠山","王二麻子","张良","谢广坤");
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for(String s:list){
            if(s.startsWith("张")){
                list1.add(s);
            }
        }
        for (String s1:list1){
            if(s1.length()==3){
                list2.add(s1);
            }
        }
        list2.forEach(System.out::println);

        System.out.println("-----------------");

    }

}
