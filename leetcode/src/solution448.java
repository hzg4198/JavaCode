import java.util.*;
import java.util.stream.Collectors;

/*
给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
        示例 1：输入：nums = [4,3,2,7,8,2,3,1]
        输出：[5,6]
        示例 2：输入：nums = [1,1]
        输出：[2]
*/
public class solution448 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(arr));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        HashSet<Integer> set =new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if(!set.contains(i + 1))list.add(i + 1);
        }
        return list;
        //优化方案：遍历nums，遇到nums[i]则将nums中num[nums[i]]处的数字变为-1；{1}
    }
}
