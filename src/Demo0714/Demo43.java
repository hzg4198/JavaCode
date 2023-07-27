package Demo0714;

import java.util.ArrayList;
import java.util.Collection;

public class Demo43 {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("zhangsan");
        coll.add("lisi");
        coll.add("laowang");
        coll.add("laoliu");

        coll.forEach(t-> System.out.println(t));
    }
}
