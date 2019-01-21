package question;

/**
 * Description:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author wangyang
 * @since 2019/1/21
 */

public class Leetcode7 {
    public static int reverse(int x) {
        boolean negative = false;
        int result = 0;
        if (x == Integer.MIN_VALUE){
            return 0;
        }
        if (x < 0){
            x = -x;
            negative = true;
        }
        while (x >= 10){
            int i = x % 10;
            result = result * 10 + i;
            x = x/10;
        }
        if (result > Integer.MAX_VALUE/10){
            return 0;
        }
        result = negative? -result*10 -x : result*10 + x;
        if ((result < 0) != negative){
            return 0;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(
                -2147483648));
    }
}
