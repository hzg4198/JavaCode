package DataStructure.unit1;

public class getNum1time {
    public static void main(String[] args) {
        int num = 97;
        System.out.println(getTimesByRecur(num));
//        System.out.println(getTimesByRecur(num));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(getTimesByRecur(Integer.MAX_VALUE));
    }

    public static int getTimes(int N){//返回一个数字二进制中1的个数
        int count = 0;
        while (N!=0){
            if(N%2==1){
                count++;
            }
            N>>=1;
        }
        return count;
    }

    public static int getTimesByRecur(int N) {//递归实现
        if (N == 1 || N == 2) {
            return 1;
        } else if (N % 2 == 1) {
            return getTimesByRecur(N >> 1) + 1;
        } else {
            return getTimesByRecur(N >> 1);
        }
    }
}
