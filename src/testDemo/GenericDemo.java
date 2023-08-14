package testDemo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class GenericDemo <T> {
    //泛型方法
    public static<T> T add(T x,T y){
        return y;
    }
    public static void main(String[] args) {
        //调用方法时不指定泛型类型，则泛型变量的类型为方法中的几种类型的同一父类的最小级，直到Object
        Number add = GenericDemo.add(1, 1.3);//x为Integer y为Double
        Integer add1 = GenericDemo.add(1, 2);//都为Integer类型
        //String和Character实现了Serializable接口和Comparable接口，
        // 原始类型使用边界类型的第一个类型变量替换
        Serializable a = GenericDemo.add("1", 'a');
        Serializable add2 = GenericDemo.add(1, false);
        //指定泛型参数的时候
        GenericDemo.<Integer> add(1,2);//编译通过
        GenericDemo.<Number> add(1,1.2);//编译通过
    }
}
