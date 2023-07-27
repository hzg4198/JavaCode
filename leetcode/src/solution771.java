
public class solution771 {
    public static void main(String[] args) {
        String s1 = "aA";
        String s2 = "aAAbbbb";
//        int i = s2.lastIndexOf(s1);
//        System.out.println(i);
        System.out.println(numJewelsInStones(s1, s2));
    }
    public static int numJewelsInStones(String jewels, String stones) {
        if(stones.length()==0)return 0;
        int count = 0;
        char[] chars = stones.toCharArray();
        for (char c : chars) {
            if (jewels.indexOf(c)!=-1)count++;
        }
        return count;
    }



}
