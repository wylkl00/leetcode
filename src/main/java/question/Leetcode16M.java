package question;

import java.util.Arrays;

/**
 * Description:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * 
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * @author wangyang
 * @since 2019/1/25
 */

public class Leetcode16M {

    public static void main(String[] args) {
        System.out.println(new Leetcode16M().threeSumClosest(new int[] {1, 1, -1, -1, 3}, -1));
    }

    //由L15的两次不完全循环+二分查找方法改造 时间复杂度O(n^2*logn) 空间复杂度O(1)
    public int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int close = Math.abs(result - target);
        for (int i = 0; i < nums.length - 2 && 3 * nums[i] < close + target; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1 && 2 * nums[j] + nums[i] < close + target; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = nums.length - 1;
                int n = target - nums[i] - nums[j];
                while (start + 1 < end) {
                    if(nums[(start + end) / 2] > n) {
                        end = (start + end) / 2;
                    } else if(nums[(start + end) / 2] < n) {
                        start = (start + end) / 2;
                    } else {
                        return target;
                    }
                }

                int startClose = Math.abs(n - nums[start]);
                int endClose = Math.abs(n - nums[end]);
                if(startClose > endClose) {
                    if(close > endClose) {
                        close = endClose;
                        result = nums[i] + nums[j] + nums[end];
                    }
                } else {
                    if(close > startClose) {
                        close = startClose;
                        result = nums[i] + nums[j] + nums[start];
                    }
                }
            }
        }
        return result;
    }

    //学习到的双指针法 时间复杂度O(n^2) 空间复杂度O(1)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        int close = Math.abs(result - target);
        for (int i = 0; i < nums.length - 2 && 3 * nums[i] < close + target; i++){
            int start = i + 1;
            int end = nums.length -1;
            while (end > start){
                int sum = nums[i] + nums[start] + nums[end];
                if (sum > target){
                        end --;
                }else if (sum < target){
                        start ++;
                }else {
                    return target;
                }
                if (Math.abs(sum-target) < close){
                    result = sum;
                    close = Math.abs(sum-target);
                }
            }
        }
        return result;
    }
}
