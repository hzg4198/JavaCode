import java.util.*;

/*
给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。
如果 h 有多种可能的值，h 指数 是其中最大的那个。
示例 1：输入：citations = [3,0,6,1,5]输出：3
解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
示例 2：输入：citations = [1,3,1]输出：1
 */  //                  [0, 1, 3, 5, 6]    0, 1  2   [100]
//                        0  1  2  3  4     0  1  2    0
//h<=c[].length  排序后的数组的索引代表什么？ 有（length-i）篇论文的引用都大于i次
//               排序后数组的值代表什么？ 至少有length-i篇论文引用了nums[i]次
public class solution274todo {
    public static void main(String[] args) {
        int[] arr =new int[]{0, 1};
        System.out.println(hIndex(arr));
    }
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        int h = 0;
        for (int i = citations.length; i > 0; i--) {
//            if(citations[i]>)

        }


        return h;
    }
}
