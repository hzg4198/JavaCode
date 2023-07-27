package Demo0714;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class mapDemo1 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("1","星期一");
        map.put("2","星期二");
        map.put("3","星期三");

//        map.forEach(new BiConsumer<String, String>() {
//            @Override
//            public void accept(String s, String s2) {
//                System.out.println(s+"="+s2);
//            }
//        });

        //简写
        map.forEach((s1,s2)-> System.out.println(s1+"="+s2));


    }
}
