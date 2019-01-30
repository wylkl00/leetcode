package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 * @author wangyang
 * @since 2019/1/28
 */

public class LeetCode18M {

    //直接从L15的代码改造 时间O(n^3logn)
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 3 && 4 * nums[i] <= target; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2 && 3 * nums[j] + nums[i] <= target; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                for (int k = j + 1; k < nums.length - 1 && 2 * nums[k] + nums[j] + nums[i] <= target; k++ ){
                    if(k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }
                    int n = target -nums[i] - nums[j] - nums[k];
                    if(map.get(n) != null && map.get(n) > k) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.add(n);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    //双指针时间O(n^3)
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3 && 4 * nums[i] <= target; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2 && 3 * nums[j] + nums[i] <= target; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int start = j + 1;
                int end = nums.length - 1;
                while (end > start) {
                    int sum = nums[i] + nums[j] + nums[start] + nums[end];
                    if(sum > target) {
                        do {
                            end--;
                        } while (end > start && nums[end] == nums[end + 1]);
                    } else if(sum < target) {
                        do {
                            start++;
                        } while (end > start && nums[start] == nums[start - 1]);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        result.add(list);
                        do {
                            end--;
                        } while (end > start && nums[end] == nums[end + 1]);
                        do {
                            start++;
                        } while (end > start && nums[start] == nums[start - 1]);
                    }
                }
            }
        }
        return result;
    }

}
