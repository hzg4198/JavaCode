import java.util.Arrays;
import java.util.TreeSet;

public class solution4 {
    public static void main(String[] args) {
        int[] a1 = {1,2,3,4,5,9,10};
        int[] a2 = {4,5,6};
        int[] a3 = {1,2};
        int[] a4 = {3};
        int[] a5 = {};
        double medianSortedArrays = findMedianSortedArrays(a3, a4);
        System.out.println(medianSortedArrays);
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = nums1.length-1;
        int p2 = nums2.length-1;
        int total = nums1.length+nums2.length-1;
        int mid = total/2;
        int[] arr = new int[nums1.length+ nums2.length];
        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1]<nums2[p2]){
                arr[total--]=nums2[p2--];
            }else {
                arr[total--]=nums1[p1--];
            }
        }
        while(p1 >= 0){
            arr[total--]=nums1[p1--];
        }
        while(p2 >= 0){
            arr[total--]=nums2[p2--];
        }
        return (nums1.length+nums2.length)%2==1?(double) arr[mid]:(arr[mid]+arr[mid+1])/2.0;
    }
}
