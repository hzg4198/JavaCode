import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。
示例 1：输入：nums = [2,7,11,15], target = 9输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：输入：nums = [3,2,4], target = 6输出：[1,2]
示例 3：输入：nums = [3,3], target = 6输出：[0,1]
                     1,2,3,3,5,8   7
                     0 1 2 3 4 5
 */
public class solution1 {
    public static void main(String[] args) {
        int[] arr = {8,5,1,2,3,3};
        System.out.println(Arrays.toString(twoSum(arr, 7)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] copyOf = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while(l < r){
            if(nums[l] + nums[r] < target){//sum小于target
                l++;
            }else if(nums[l] + nums[r] > target){
                r--;
            }else break;
        }
        int indexl = 0;
        int indexr = copyOf.length - 1;
            while (copyOf[indexl] != nums[l])indexl++;
            while (copyOf[indexr] != nums[r])indexr--;

        return new int[]{indexl,indexr};//双指针
    }


}
