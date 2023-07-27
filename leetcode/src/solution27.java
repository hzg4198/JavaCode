import com.sun.deploy.panel.JreTableModel;

/*
 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class solution27 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int[] arr1 = {3,2,2,3};
        int[] arr2 = {2};
        System.out.println(removeElement(arr2, 3));
    }
    public static int removeElement(int[] nums, int val) {
        if(nums.length==0)return 0;
        int l = 0;
        int r = nums.length;
        //双指针前后遍历，后指针找不是val值的位置，前指针找val值的位置
        while(l<r){
            if(nums[l] == val){
                nums[l]=nums[r - 1];
                r--;
            }else l++;
        }
        return l;
    }

}
