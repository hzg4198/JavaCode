package Demo0714;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        String str = "abcdea";
        count(str);
    }

    public static void count(String str){
        HashMap<Character,Integer> hashMap = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if(hashMap.containsKey(c)){
                Integer value = hashMap.get(c);
                value++;
                hashMap.put(c,value);
            }else {
                hashMap.put(c,1);
            }
        }
        System.out.println(hashMap);
    }
}
