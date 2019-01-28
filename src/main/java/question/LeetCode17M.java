package question;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Description:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * @author wangyang
 * @since 2019/1/25
 */

public class LeetCode17M {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return  new ArrayList<>();
        }
        String [][] mapping = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};;
        List<String> result = Arrays.asList(mapping[Character.digit(digits.charAt(0),10)-2]);
        for (int i = 1 ; i<digits.length(); i++){
            List<String> temp = new ArrayList<>();
            for (String str : result){
                for (String append : mapping[Character.digit(digits.charAt(i),10)-2]){
                    temp.add(str+append);
                }
            }
            result = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(
                new LeetCode17M().letterCombinations("2345")
        );

    }
}
