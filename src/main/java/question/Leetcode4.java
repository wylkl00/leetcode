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

public class Leetcode4 {
    public static double  findMedianSortedArrays(int[] nums1, int[] nums2) {
        //int findNo = (nums1.length + nums2.length + 1)/2;
        //int start1 = 0 ;
        //int end1 = nums1.length-1;
        //int start2 = 0 ;
        //int end2 = nums2.length-1;
        //int i1 = (start1 + end1)/2;
        //int i2 = (start2 + end2)/2;
        //int find2 = 0;
        //int find1 = 0;
        //
        //
        //while(find1+find2+1 >= findNo){
        //    if (nums1[i1] <= nums2[i2]){
        //        find2 = binaryFind(i1,nums2);
        //        find1 = i1;
        //    }else{
        //        find1 = binaryFind(i2,nums1);
        //        find2 = i2;
        //    }
        //}


        int findNo = (nums1.length + nums2.length + 1)/2;
        int find1 = findNo * nums1.length/(nums1.length + nums2.length);
        int find2 = findNo * nums2.length/(nums1.length + nums2.length);
        int headPointer1 = find1 - 1;
        int headPointer2 = find2 - 1;
        int tailPointer1 = nums1.length - find1;
        int tailPointer2 = nums2.length - find2;
        int headfind = 0;
        int tailfind = 0;
        //正向寻找
        if (nums1[headPointer1] <= nums2[headPointer2]){
            headfind = binaryFind(nums1[headPointer1],nums2,0, headPointer2);
            headfind = headfind + find1;
        }else{
            headfind = binaryFind(nums2[headPointer1],nums1,0, headPointer1);
            headfind = headfind + find2;
        }

        //反向寻找
        if (nums1[tailPointer1] >= nums2[tailPointer2]){
            tailfind = binaryFind2(nums1[tailPointer1],nums2,0, tailPointer2);
            tailfind = tailfind + find1;
        }else{
            tailfind = binaryFind2(nums2[tailPointer2],nums1,0, tailPointer1);
            tailfind = tailfind + find2;
        }



        return 0;

    }

    public static boolean isEven(int n){
        return n%2==0;
    }

    //二分查找数组arr中小于等于n的个数
    public static int binaryFind(int n, int[] arr, int start, int end){
        int i = (start + end)/2;
        while(start != end){
            if (arr[i] <= n){
                start = i + 1;
            }else {
                end = i -1;
            }
            i = (start + end)/2;
        }
        return arr[i] <= n ? i + 1 : i;
    }

    //二分查找数组arr中大于等于n的个数
    public static int binaryFind2(int n, int[] arr, int start, int end){
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,4,4,4,4,4};
        Arrays.sort(arr);

    }
}
