/*
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
子数组 是数组中的一个连续部分。
示例 1：输入：nums = [-2,1,-3,4,-1,2,1,-5,4]输出：6解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
示例 2：输入：nums = [1]输出：1
示例 3：输入：nums = [5,4,-1,7,8]输出：23
 */
public class solution53Todo {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(maxSubArray(arr));
    }
//    public static int maxSubArray(int[] nums) {
    /*    int thisSum = 0;
        int maxSum = 0;
        for(int i = 0; i < nums.length; i++){
            thisSum += nums[i];
            if(thisSum > maxSum){
                maxSum = thisSum;
            }else if(thisSum < 0){
                thisSum = 0;
            }
        }
        return maxSum;*/
       /* maxSum(nums,0, nums.length - 1);

    }
    public static int maxSum(int[] arr, int l, int r){
        int center = (l + r)/2;


    }*/
}
