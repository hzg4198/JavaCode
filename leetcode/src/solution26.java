import java.util.Arrays;
import java.util.List;

//删除有序数组中的重复项 （原地算法）
/*
    给你一个 升序排列 的数组 nums ，
    请你 原地 删除重复出现的元素，
    使每个元素 只出现一次 ，返回删除后数组的新长度。
    元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 */
public class solution26 {
    public static void main(String[] args) {
        int[] arr1 = {0,0,1,1,1,2,2,3,3,4};
        int[] arr2 = new int[]{1,1,2};
        System.out.println(removeDuplicates(arr1));
    }
    public static int removeDuplicates(int[] nums) {
        int l = 0;//左指针
        int r = 1;//右指针
        while (r != nums.length){
            if(nums[r]==nums[l]){
                r++;
                continue;
            }
            nums[++l] = nums[r];

        }
        System.out.println(Arrays.toString(nums));
        return ++l;
    }
}
