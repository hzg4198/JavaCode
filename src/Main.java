import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        String fn = fn(arr);
        System.out.println(fn);
        System.out.println(Arrays.toString(arr));
        System.out.println("--------------------");
        final int[] arr1 = {1,2,3,4,5};
        arr1[0] = 5;
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
    }

    private static void fn1(StringBuffer a1) {
        a1.append("test");
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
}
