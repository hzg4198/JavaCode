import java.lang.reflect.Array;

public class solution11 {
    public static void main(String[] args) {

    }
    public static int maxArea(int[] height) {
        int r = 0;//左指针
        int l = height.length - 1;//右指针
        int curCap = Math.min(height[r],height[l])*(l-r);
        while(r<l){
            if (height[r] > height[l]) l--;
            else r++;
            curCap = Math.max(curCap,Math.min(height[r],height[l])*(l-r));
        }
        return curCap;
    }
}
