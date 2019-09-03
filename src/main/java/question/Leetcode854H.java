package question;

import com.sun.org.apache.regexp.internal.RE;
import sun.security.krb5.internal.APOptions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
 *
 * 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = "ab", B = "ba"
 * 输出：1
 * 示例 2：
 *
 * 输入：A = "abc", B = "bca"
 * 输出：2
 * 示例 3：
 *
 * 输入：A = "abac", B = "baca"
 * 输出：2
 * 示例 4：
 *
 * 输入：A = "aabc", B = "abca"
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= A.length == B.length <= 20
 * A 和 B 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母。
 *
 * @author wangyang
 * @since 2019/2/20
 */

public class Leetcode854H {

    //fixme 思路有误
    public int kSimilarity(String A, String B) {
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(new Leetcode854H().kSimilarity("aabbccddee","cdacbeebad"));
    }
}