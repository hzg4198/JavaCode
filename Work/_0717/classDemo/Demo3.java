package classDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class Demo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张三丰","张无忌","张翠山","王二麻子","张良","谢广坤");
        //以张开头 名字为三个字符
//        list.stream().filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.startsWith("张")&&s.length()==3;
//            }
//        });
        System.out.println("---------------");
        StringOperator stringOperator =new StringOperator();
        list.stream().filter(stringOperator::StringJudge).forEach(System.out::println);

        System.out.println("-------------------");
        //在本类中使用方法

    }

}
