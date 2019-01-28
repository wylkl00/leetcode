package question;

/**
 * Description:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * @author wangyang
 * @since 2019/1/24
 */

public class LeetCode14E {
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        int index = strs[0].length() - 1;
        for(int i = 1; i < strs.length; i++){
            int j;
            for ( j = 0; j <= index && j < strs[i].length(); j++){
                if (strs[0].charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            index = j-1;
        }
        return strs[0].substring(0, index+1);
    }

    public static void main(String[] args) {
        new LeetCode14E().longestCommonPrefix(new String[]{"aa","a"});
    }

    //水平扫描
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        int i;
        for (i = 0; i<strs[0].length(); i++ ){
            for (int j = 1; j <strs.length; j++){
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, i);
    }
}
