package question;

import sun.applet.Main;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author wangyang
 * @since 2018/11/20
 */

public class Leetcode3 {

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int longestEnd = 0;
        int longestStart= 0;
        int endPoint = 0;
        int startPoint = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (s.length() - startPoint > longestEnd - longestStart) {
            if (endPoint >= s.length()){
                longestEnd = endPoint;
                longestStart = startPoint;
                break;
            }
            if (map.get(chars[endPoint]) != null && map.get(chars[endPoint]) >= startPoint){
                if (endPoint - startPoint > longestEnd - longestStart){
                    longestEnd = endPoint;
                    longestStart = startPoint;
                }
                startPoint = map.get(chars[endPoint]) + 1;

            }
            map.put(chars[endPoint], endPoint);
            endPoint++;
        }

        return longestEnd - longestStart;
    }

    public static void main(String[] args) {
        Leetcode3 l3 = new Leetcode3();
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
