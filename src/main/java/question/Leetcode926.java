package question;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * 如果一个由 '0' 和 '1' 组成的字符串，是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 *
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 *
 * 返回使 S 单调递增的最小翻转次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入："00110"
 * 输出：1
 * 解释：我们翻转最后一位得到 00111.
 * 示例 2：
 *
 * 输入："010110"
 * 输出：2
 * 解释：我们翻转得到 011111，或者是 000111。
 * 示例 3：
 *
 * 输入："00011000"
 * 输出：2
 * 解释：我们翻转得到 00000000。
 *
 *
 * 提示：
 *
 * 1 <= S.length <= 20000
 * S 中只包含字符 '0' 和 '1'
 *
 * @author wangyang
 * @since 2018/11/21
 */

public class Leetcode926 {

    //遍历字符串，去寻找一个分界点，使得该分界点之前1的个数和分界点之后0的个数之和最小
    //第一遍遍历整个字符串可以把前n位0的个数存在一个哈希表里，第二遍遍历去寻找分界点的时候只用去查哈希表里前n为1个数就可以算出前n位1的个数从而知道分界点之后0的个数，直接求和 整个时间复杂度依然是O(n）
    public static int minFlipsMonoIncr(String S) {
        char[] charS = S.toCharArray();
        int count1 = 0;
        int minFlips = charS.length;
        //在k位以及k位之前，1的个数为v
        Map<Integer,Integer> map = new HashMap<>(charS.length);
        for (int i = 0; i < charS.length ; i++){
            if (charS[i] == '1'){
                count1++;
            }
            map.put(i,count1);
        }
        map.put(-1, 0);
        int count0 = charS.length - count1;

        for (int j = 0; j<= charS.length; j++ ){
            //j位以前1的个数加上j位以及j位以后0的个数即为需要翻转的总次数
            int flips =  map.get(j-1) + (count0 - (j - map.get(j-1)));
            if (flips < minFlips){
                minFlips = flips;
            }
        }

        return minFlips;
    }

    public static void main(String[] args) {
        minFlipsMonoIncr("00011000");
    }
}
