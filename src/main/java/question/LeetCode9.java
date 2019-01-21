package question;

/**
 * Description: TODO
 *
 * @author wangyang
 * @since 2019/1/21
 */

public class LeetCode9 {
    //翻转与原值比较
    public boolean isPalindrome1 (int x) {
        if (x < 0){
            return false;
        }
        int reverse = 0;
        int remain = x;
        while (remain >= 10){
            int i = remain % 10;
            reverse = reverse * 10 + i;
            remain = remain/10;
        }
        if (reverse > Integer.MAX_VALUE/10){
            return false;
        }
        reverse = reverse*10 + remain;
        return x == reverse;
    }

    //官方解法翻转一半
    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        if (x < 10){
            return true;
        }
        if (x % 10 == 0){
            return false;
        }
        int reverse = 0;
        int remain = x;
        int i =0 ;
        while (remain > reverse){
            i = remain % 10;
            reverse = reverse * 10 + i;
            remain = remain/10;
        }
        return remain == reverse || remain == 0 || remain * 10 + i == reverse;
    }

public static void main(String[] args) {
    isPalindrome(10);
}
}
