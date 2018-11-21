package question;

import sun.applet.Main;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Description:
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author wangyang
 * @since 2018/11/12
 */

public class Leetcode1 {

    /*
     1.把数组内的数存到一个（key，value）= （nums值，所在的位置）的map里（空间换时间）
     2.逐次计算target-nums的值是否在map中
     O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, nums.length).forEachOrdered((x -> map.put(nums[x], x)));
        int i = 0;
        for (; i < nums.length; i++){
            if (map.get(target-nums[i]) != null && map.get(target-nums[i]) != i) break;
        }
        return new int[]{i, map.get(target-nums[i])};
    }

    public static void main(String[] args) {
        Leetcode1 l1 = new Leetcode1();
        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
