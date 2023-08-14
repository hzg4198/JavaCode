package testDemo;

import java.util.Objects;

public class reverseChar {
    public static void main(String[] args) {
        float a = 0.1f;
        double b = 0.1;
        System.out.println(a);
        System.out.println(a==b);
        System.out.println(Objects.equals(a,b));
    }
}
class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            char c = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i]=c;
        }
    }
}

