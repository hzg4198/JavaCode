import com.sun.xml.internal.ws.api.model.CheckedException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        int a1 = 1;
        int a2 =2;
        int total = a1 + a2;
        System.out.println(total);
        System.out.println(total);
        /*int[] arr = {1,2,3,4};
        String fn = fn(arr);
        System.out.println(fn);
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------");
        final int[] arr1;
        int[] arr123 = {1,2,3,4,5};
        arr1 = arr123;
        arr1[0] = 5;
        arr1[0] = 1;
        arr1[1] = 21;
        System.out.println(Arrays.toString(arr1));
        System.out.println("---------------------");
        final String a = "abc";
        System.out.println(a);
        System.out.println("------------------");
        StringBuilder sb1 = new StringBuilder("A");
        StringBuffer a1 = new StringBuffer("A");

        System.out.println(sb1);
        fn1(sb1);
        fn1(a1);
        System.out.println(sb1);
        System.out.println(a1);
        System.out.println("--------------------");
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("A");
        List list2 = list1;
        list2.add(1);
        System.out.println("-------------------------");
        //1的ascii码值为49
        System.out.println(1+"1"+2);
        System.out.println(1+3+"2");
        System.out.println("1"+1+1);
        System.out.println(1+'1'+1);
        System.out.println(1+1+'1');
        System.out.println(1+'1'+"1");
        byte b1 = 1;byte b2 = 2;int i1 = 1;long l1 = 1;double d1 = 1.0;float f1 = 1.0F;*/
//        List<Integer> list1 = new ArrayList<>();
//        List<String> list2 = new ArrayList<>();
//        list1.add(123);
//        list2.add("abc");
//        System.out.println(list1.getClass() == list2.getClass());
    }

    private static void fn1(StringBuffer a1) {
        a1.append("testDemo");
    }

    private static void fn1(StringBuilder sb1) {
        sb1.append("TEST");
    }

    public static String fn(int[] arr){
        try{
            arr[0] = 5;
            return "1";
        }finally {
            arr[0] = 9;
            return "-1";
        }

    }

//    //返回有序数组的中位数
//    public int midNum(int[] arr){
//        int len = arr.length;
////        return len % 2 != 0 ? arr[Math.min(len,len/2+1)] :
//    }
}
