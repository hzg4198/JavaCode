package classDemo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Demo1 {
    public static void main(String[] args) {
        Integer[] arr = {3,4,2,5,6,1};
        
//        Arrays.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });

        //lambda
//        Arrays.sort(arr,((o1, o2) -> o2-o1));
//        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));
        System.out.println("---------------");
        Arrays.sort(arr,Demo1::compareInt);
        System.out.println(Arrays.toString(arr));

        /*
        方法的引用
        1，函数式接口
        2，被引用的方法已经存在
        3，形参和返回值保持一致
        4.被引用的方法的功能满足当前的需求
         */
    }
    public static int compareInt(int num1,int num2){
        return num2-num1;
    }

}
