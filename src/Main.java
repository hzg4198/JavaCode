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
