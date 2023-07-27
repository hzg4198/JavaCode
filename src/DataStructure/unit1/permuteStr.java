package DataStructure.unit1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class permuteStr {
    public static void main(String[] args) {

    }

    public static void permute(String str){
        char[] chars = str.toCharArray();
        permute(chars,0, chars.length);
    }
    //char[] [a,b,c.d]
   //         0 1 2 3
    private static void permute(char[] str,int low, int high){
        if(str.length == 1) System.out.println(str);
    }
}
