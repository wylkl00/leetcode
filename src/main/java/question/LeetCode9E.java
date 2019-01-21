package question;

/**
 * Description:
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @author wangyang
 * @since 2019/1/21
 */

public class LeetCode9E {

    //官方解法翻转一半
    public static boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        if(x < 10) {
            return true;
        }
        if(x % 10 == 0) {
            return false;
        }
        int reverse = 0;
        int remain = x;
        int i = 0;
        while (remain > reverse) {
            i = remain % 10;
            reverse = reverse * 10 + i;
            remain = remain / 10;
        }
        return remain == reverse || remain == 0 || remain * 10 + i == reverse;
    }

    //翻转与原值比较
    public boolean isPalindrome1(int x) {
        if(x < 0) {
            return false;
        }
        int reverse = 0;
        int remain = x;
        while (remain >= 10) {
            int i = remain % 10;
            reverse = reverse * 10 + i;
            remain = remain / 10;
        }
        if(reverse > Integer.MAX_VALUE / 10) {
            return false;
        }
        reverse = reverse * 10 + remain;
        return x == reverse;
    }
}
