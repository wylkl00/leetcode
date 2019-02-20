package question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * @author wangyang
 * @since 2019/2/1
 */

public class Leetcode22M {

    public List<String> generateParenthesis1(int n) {
        Map<String,Integer> map = new HashMap<>();
        map.put("(",1);
        for (int i = 1; i < 2 * n ; i++){
            Map<String,Integer> temp = new HashMap<>();
            int j = i;
            map.forEach((k,v) ->{
                if (v < n){
                    temp.put(k+"(", v+1);
                }
                if (2 * v > j){
                    temp.put(k+")", v);
                }
            });
            map = temp;
        }
        return new ArrayList<>(map.keySet());
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        recurse(0,0,n,result,"");
        return result;
    }

    public void recurse(int left, int right, int n, List<String> result, String str){
        if (left +right >= 2 * n){
            result.add(str);
            return;
        }
        if (left > right){
            recurse(left,right+1,n,result,str+")");
        }
        if (left < n){
            recurse(left+1,right,n,result,str+"(");
        }
    }

    public static void main(String[] args) {
        new Leetcode22M().generateParenthesis(3);
    }
}
