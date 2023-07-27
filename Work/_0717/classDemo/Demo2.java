package classDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo2 {
    public static void main(String[] args) {
        //集合 把集合中的字符串转化为int类型
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"1","2","3","45","56");
        //常规方式
        ArrayList<Integer> list1 = new ArrayList<>();
        for (String str : list) {
            int i = Integer.parseInt(str);
            list1.add(i);
        }
        System.out.println(list1);
        //map
        List<Integer> list2 = list.stream().map(new Function<String, Integer>() {

            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        }).collect(Collectors.toList());
        System.out.println(list2);
        System.out.println("------------------------");
        //方法引用
        List<Integer> list3 = list.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(list3);
    }
}
