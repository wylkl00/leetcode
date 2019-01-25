package question;

/**
 * Description: TODO
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
