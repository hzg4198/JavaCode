package Demo0714;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class StreamDemo2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌-15","周芷若-14","赵敏-13","张三丰-100","张翠山-40","张梁-39");
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                String[] arr = s.split("-");
                String ageString = arr[1];
                return Integer.parseInt(ageString);
            }
        }).forEach(System.out::println);
    }
}
