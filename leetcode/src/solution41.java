import java.util.Arrays;

/*
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
示例 1：输入：nums = [1,2,0]输出：3
示例 2：输入：nums = [3,4,-1,1]输出：2
示例 3：输入：nums = [7,8,9,11,12]输出：1
 */
public class solution41 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,-1,1};
        int[] arr1 = new int[]{1,2,0,1,3,2,6};
        int[] arr2 = new int[]{4,2,5,6,8,7,1,3};
        //                     1,3,2,1,4,6,4,6
        //                     0 1 2 3 4 5 6 7
//        firstMissingPositive(arr);
        int[] arr3 = new int[]{1};
        int[] arr4 = new int[]{1,2,3,5,4};
        System.out.println(firstMissingPositive(arr4));
//        firstMissingPositive(arr2);
    }

    public static int firstMissingPositive(int[] nums) {
/*        for (int i = 0; i < nums.length; i++) {//原地哈希排序
            if(nums[i] == (i + 1) || nums[i] > nums.length || nums[i] <= 0 || nums[i] == nums[nums[i] - 1]) {
                continue;
            } else {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
                i--;
            }
        }
        int min = 0;
        for (int num : nums) {
            if (++min != num) return min;
        }

        System.out.println(Arrays.toString(nums));
        return nums.length+1;*/
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<=0||nums[i]==i + 1||nums[i]> nums.length){
                continue;
            }
            int temp = nums[i];
            nums[i] = nums[nums[i]-1];
            nums[nums[i]-1]=temp;
            i--;
        }
        int min = 0;
        for (int num : nums) {
            if(++min!=num)return min;
        }
        return nums.length+1;
    }
}
