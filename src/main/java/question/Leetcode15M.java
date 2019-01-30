package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * @author wangyang
 * @since 2019/1/25
 */

public class Leetcode15M {

    //两次不完全循环+二分查找 时间复杂度O(n^2*logn) 空间复杂度O(1)
    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i< nums.length-2 && nums[i]<= 0 ; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length-1 && 2*nums[j]+nums[i] <= 0; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int n = -nums[i]-nums[j];
                if (Arrays.binarySearch(nums,j+1 ,nums.length,n)>0){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(n);
                    list.add(nums[j]);
                    result.add(list);
                }
            }
        }
        return result;
    }


    //用哈希表 时间O(n^2)空间O(n)
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++ ){
            map.put(nums[i],i);
        }
        for (int i = 0; i< nums.length-2 && nums[i]<= 0 ; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length-1 && 2*nums[j]+nums[i] <= 0; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int n = -nums[i]-nums[j];
                if (map.get(n) != null && map.get(n) > j){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(n);
                    list.add(nums[j]);
                    result.add(list);
                }
            }
        }
        return result;
    }

    //双指针 时间O（n^2）空间O(1）
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i< nums.length-2 && nums[i]<= 0 ; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int start = i + 1;
            int end = nums.length -1;
            while (end > start){
                if (nums[i] + nums[start] + nums[end] > 0){
                    do {
                        end --;
                    }while (end > start && nums[end] == nums[end + 1]);
                }else if (nums[i] + nums[start] + nums[end] < 0){
                    do {
                        start ++;
                    }while (end > start && nums[start] == nums[start - 1]);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    do {
                        end --;
                    }while (end > start && nums[end] == nums[end + 1]);
                    do {
                        start ++;
                    }while (end > start && nums[start] == nums[start - 1]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode15M().threeSum(new int[]{
                -1,0,1,2,-1,-4}));
    }
}
