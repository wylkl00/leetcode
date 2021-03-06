package question;

/**
 * Description:
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 *
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 *
 * @author wangyang
 * @since 2019/1/24
 */

public class Leetcode11M {
    //O(n^2)
    public int maxArea1(int[] height) {
        int result = 0;
        for(int i = 0; i < height.length; i++ ){
            for(int j = i+1; j < height.length; j++){
                int area = (j-i) * Math.min(height[i] ,height[j]);
                if (area > result){
                    result = area;
                }
            }
        }
        return result;
    }

    //O(n)双指针法
    public int maxArea(int[] height) {
        int i = 0, j = height.length-1, result = 0, area = 0;
        while (j > i){
            if (height[i] >= height[j]){
                area = height[j] * (j-i);
                j--;
            }else {
                area = height[i] * (j-i);
                i++;
            }
            if (area > result){
                result = area;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Leetcode11M().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
