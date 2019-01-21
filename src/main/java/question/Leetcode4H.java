package question;

import sun.security.util.Length;

import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * Description:
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author wangyang
 * @since 2018/11/21
 */

public class Leetcode4H {
        /*
    来自官方解法：
       通过二分查找找到合适的i，使得左右的元素相等且左边的都比右边小。
       其中j=(m+n+1)/2 - i  为了让j不为负 限定n>=m （+1是为了考虑m+n为奇数的情况）

              left_part          |        right_part
        A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
        B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     */
        public static double  findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1.length > nums2.length){
                int[] temp = nums1;
                nums1 = nums2;
                nums2 = temp;
            }
            int m = nums1.length;
            int n = nums2.length;
            int min = 0;
            int max = m;
            int i = (min + max)/2;
            int j = (m+n+1)/2 - i;
            while (true){
                if (i != 0 && nums1[i-1] > nums2[j]){
                    max = i - 1;
                }else if (i != m && nums2[j-1] > nums1[i]){
                    min = i + 1;
                }else {
                    break;
                }
                i = (min + max)/2;
                j = (m+n+1)/2 - i;
            }
            if ((m + n) % 2 == 1) {
                if (i == 0){
                    return  nums2[j-1];
                }else {
                    return Math.max(nums1[i-1], nums2[j-1]);
                }
            }else {
                if (i == 0){
                    if (j == n){
                        return (nums1[0] + nums2[n-1])/2.0;
                    }
                    if (m == 0){
                        return  (nums2[j-1] + nums2[j])/2.0;
                    }
                    return (nums2[j-1] +  Math.min(nums1[0],nums2[j]))/2.0;
                }
                if (i == m){
                    if (j == 0){
                        return  (nums1[m-1] + nums2[0])/2.0;
                    }
                    return (Math.max(nums1[m-1], nums2[j-1]) + nums2[j])/2.0;
                }
                return (Math.max(nums1[i-1], nums2[j-1]) + Math.min(nums1[i], nums2[j]))/2.0;
            }
        }


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,4,4,4,4,4};
        System.out.println(
                findMedianSortedArrays(new int[]{1,2}, new int[]{-1,3} )
        );

    }
}
