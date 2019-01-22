package question;

import java.util.ArrayList;
import java.util.List;
import static java.util.AbstractMap.SimpleEntry;

/**
 * Description:
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: '*' 代表可匹配零个或多个前面的元素, 即可以匹配 'a' 。因此, 重复 'a' 一次, 字符串可变为 "aa"。
 * 示例 3:
 *
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个('*')任意字符('.')。
 * 示例 4:
 *
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 'c' 可以不被重复, 'a' 可以被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 *
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * @author wangyang
 * @since 2019/1/21
 */

public class LeetCode10H {
    public  boolean isMatch(String s, String p) {
        if (p.length()==0){
            if (s.length() == 0){
                return true;
            }
            return false;
        }

        int i = 0;
        char[] pArr = p.toCharArray();
        List<SimpleEntry<Character, Boolean>> table = new ArrayList<>();
        SimpleEntry entry = null;

        //生成table的数据结构
        while (i < pArr.length){
            if (i+1 < pArr.length && pArr[i+1] == '*'){
                //对table进行优化：如果在a*后面还有a*则只放入一次
                if (entry != null && entry.getValue().equals(true) && (entry.getKey().equals(pArr[i]) || entry.getKey().equals('.')) ){
                    i=i+2;
                    continue;
                }
                //对table进行优化：如果在a*还有.*则移除a*直接放入.*
                if (entry != null && entry.getValue().equals(true) && pArr[i]=='.'){
                    table.remove(table.size()-1);
                }
                entry = new SimpleEntry(pArr[i], true);
                table.add(entry);
                i++;
            }else {
                entry = new SimpleEntry(pArr[i], false);
                table.add(entry);
            }
            i++;
        }

        //用来存放p中每一个字符匹配到s中的哪一位
        int[] indexArr = new int[table.size()];
        char[] charArr = s.toCharArray();
        int sn = 0;
        int pn = 0;
        //贪心然后回溯
        while (pn < table.size()){
            //当前匹配字符
            char ch  = table.get(pn).getKey();
            //是否带*
            boolean repeat = table.get(pn).getValue();
            if (repeat){
                while(sn < charArr.length && (ch == charArr[sn] || ch == '.')){
                    sn++;
                }
                indexArr[pn] = sn;
            }else{
                if (sn < charArr.length && (ch == charArr[sn] || ch == '.')){
                    sn++;
                    indexArr[pn] = sn;
                }else{
                    //回溯
                    do {
                        pn = findLast(pn,table);
                        if (pn > -1){
                            indexArr[pn]--;
                        }else {
                            return false;
                        }
                    } while (pn == 0 ? indexArr[pn] < 0 : indexArr[pn]<indexArr[pn-1] );
                    sn = indexArr[pn];
                }
            }
            pn++;
        }
        return sn == charArr.length;
    }
    
    //找到上一个带*的字符
    private  int findLast(int pn,  List<SimpleEntry<Character, Boolean>> table){
        int i = pn - 1 ;
        while (i>-1 && !table.get(i).getValue()){
            i--;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode10H().isMatch(
                "ab",
                ".*c"));
    }
}
