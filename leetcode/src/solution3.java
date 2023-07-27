public class solution3 {
    public static void main(String[] args) {
        String s ="pwwkew";
        System.out.println(lengthOfLongestSubstring("dvdf"));
//        System.out.println(s.substring(0,2));
    }
    public static int lengthOfLongestSubstring(String s) {
        //前后指针，后指针一直++，如果与前指针相同则记录length更新max，最后返回max

        if(s.length()==0)return 0;
        int l = 0;
        int r = 0;
        int max = 1;
        while(r < s.length()){
            if(s.substring(l,r).indexOf(s.charAt(r))!=-1){
                max = Math.max(max, (r - l));
                l++;
            }
            r++;
        }
        return Math.max(max,r - l);
    }
}
