import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class solution3 {
    public static void main(String[] args) {
        String s ="pwwkew";
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(s.substring(0,2));
    }
    public static int lengthOfLongestSubstring(String s) {
        //前后指针，后指针一直++，如果与前指针相同则记录length更新max，最后返回max
        if(s.length() == 0)return 0;
        int pre=0,cur=0;
        int maxLen=Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        while(cur<s.length()){
            char c = s.charAt(cur);
            if(map.containsKey(c)&&map.get(c)>=pre){
                pre = map.get(c) + 1;
            }
            map.put(c,cur);
            cur++;
            maxLen = Math.max(maxLen,cur-pre);

        }
        return maxLen;
    }
}
