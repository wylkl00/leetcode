package question;

import com.sun.javafx.collections.MapListenerHelper;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * Description:
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * @author wangyang
 * @since 2019/1/7
 */

public class Leetcode5M {

    //中心扩展法 时间O(n^2) 空间O(1）
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        char[] arr = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            //以arr[i]为中心
            for (int j = 1; i - j >= 0 && i + j <= arr.length - 1; j++) {
                if(arr[i - j] != arr[i + j]) {
                    break;
                }
                if(2 * j + 1 > (end - start + 1)) {
                    end = i + j;
                    start = i - j;
                }
            }
            //以arr[i]后的间隔为中心
            for (int j = 1; i - j + 1 >= 0 && i + j <= arr.length - 1; j++) {
                if(arr[i - j + 1] != arr[i + j]) {
                    break;
                }
                if(2 * j > (end - start + 1)) {
                    end = i + j;
                    start = i - j + 1;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    //动态规划 时间O(n^2) 空间 优化后 O(n）
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        char[] arr = s.toCharArray();
        boolean [] lastMap = new boolean [arr.length];
        boolean [] map = new boolean [arr.length];
        int start = 0;
        int end = 0;
        for(int i = arr.length-1 ; i >= 0; i-- ){
            for (int j = i ; j<arr.length; j++){
                if (isPalindrome(i,j,arr,lastMap)){
                    map[j] = true;
                    if(j-i>end-start){
                        end = j;
                        start = i;
                    }
                }
            }
            lastMap = map;
            map = new boolean [arr.length];
        }
        return s.substring(start, end + 1);
    }

    private static boolean isPalindrome(int i, int j,char[] arr, boolean [] map){
        if (j-i == 0) return true;
        if (j-i == 1) return arr[i]==arr[j];
        return map[j-1] && arr[i]==arr[j];
    }

    //Manacher算法 时间O(n) 空间O(1)
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        char[] news =new char[s.length()*2+1];
        for (int i =0 ;i <s.length()*2+1;i++){
            if (i % 2 ==0) {
                news[i] = '*';
            }else {
                news[i] = s.charAt((i-1)/2);
            }
        }
        int[] radius = new int[news.length];
        int id = 0;
        int mx= 0;
        for (int i = 1; i<radius.length; i++){
            //mx不需要变
            if (mx > i && i + radius[2 * id -i] < mx){

                radius[i] = radius[2 * id -i];
                //mx过小
            }else {
                while ( mx + 1 < news.length && 2 * i - mx -1 >= 0 && news[mx + 1] == news[2 * i - mx -1]){
                    mx++;
                }
                radius[i] = mx - i;
                id = i;
            }
        }
        int result = 0;
        int positon = 0;
        for (int i = 0; i<radius.length; i++){
            if (radius [i] > result){
                positon = i;
                result = radius [i];
            }
        }


        return result % 2 == 1 ? s.substring((positon - 1)/2 - ((result-1)/2), (positon - 1)/2 + ((result-1)/2) + 1) : s.substring(positon/2 - (result/2), positon /2 + result/2);
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }
}
