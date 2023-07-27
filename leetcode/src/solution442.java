/*
给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
示例 1：输入：nums = [4,3,2,7,8,2,3,1]输出：[2,3]
示例 2：输入：nums = [1,1,2]输出：[1]
示例 3：输入：nums = [1]输出：[]
 */

import java.util.*;

public class solution442 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(arr));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.stream(nums).boxed().forEach(o->{
            if(map.containsKey(o)){
                Integer value = map.get(o);
                map.put(o,++value);
            }else{
                map.put(o,1);
            }
        });
        List<Integer> list = new ArrayList<>();
        map.forEach((o1,o2)->{
            if(o2 == 2){
                list.add(o1);
            }
        });
        return list;
    }
}
