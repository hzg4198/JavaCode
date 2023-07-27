package Demo0714;

import java.util.Arrays;
import java.util.Collections;

public class Demo3 {
    public static void main(String[] args) {
        String[] arr = {"a","aaaa","aa","aaaaaa"};
        Arrays.sort(arr,(o1, o2) -> o1.length()-o2.length());
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
