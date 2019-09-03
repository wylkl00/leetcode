package question;

import com.sun.org.apache.regexp.internal.RE;
import sun.security.krb5.internal.APOptions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
 *
 * 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = "ab", B = "ba"
 * 输出：1
 * 示例 2：
 *
 * 输入：A = "abc", B = "bca"
 * 输出：2
 * 示例 3：
 *
 * 输入：A = "abac", B = "baca"
 * 输出：2
 * 示例 4：
 *
 * 输入：A = "aabc", B = "abca"
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= A.length == B.length <= 20
 * A 和 B 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母。
 *
 * @author wangyang
 * @since 2019/2/20
 */

public class Leetcode854H {

    public int kSimilarity(String A, String B) {
        int result = 0;
        char[] charA = A.toCharArray();
        char[] charB = B.toCharArray();
        //compare
        Map<Character, List<Integer>> aMap = new HashMap<>();
        Map<Character, List<Integer>> bMap = new HashMap<>();
        for (int i = 0 ; i < charA.length; i ++ ) {
            if(charA[i] != charB[i]) {
                if(aMap.get(charA[i]) == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    aMap.put(charA[i] , list);
                } else {
                    aMap.get(charA[i] ).add(i);
                }

                if(bMap.get(charB[i]) == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    bMap.put(charB[i], list);
                } else {
                    bMap.get(charB[i]).add(i);
                }
            }
        }
            List <Map.Entry<Character,List<Integer>>> blist = new ArrayList<>(bMap.entrySet());
            blist.sort(Comparator.comparingInt(entry -> entry.getValue().size()));
            for (Map.Entry<Character,List<Integer>> entry : blist){
                List<Integer> bPositions = entry.getValue();
                List<Integer> aPositions = aMap.get(entry.getKey());
                Iterator<Integer>  bi = bPositions.iterator();
                while (bi.hasNext()){
                    int bPosition = bi.next();
                    Iterator<Integer>  ai =  aPositions.iterator();
                    while (ai.hasNext()){
                         int aPosition = ai.next();
                         if (charA[bPosition] == charB[aPosition]){
                            result ++ ;
                            ai.remove();
                            bi.remove();
                            aMap.get(charA[bPosition]).remove(new Integer(bPosition));
                            bMap.get(charB[aPosition]).remove(new Integer(aPosition));
                            break;
                         }
                    }
                }
                while (!bPositions.isEmpty()){
                    result++;
                    int bRemove = bPositions.remove(0);
                    int aRemove = aPositions.remove(0);
                    //B的aRemove与bremove交换位置
                    List <Integer> list = bMap.get(charB[aRemove]);
                    list.set(list.indexOf(aRemove),bRemove);
                    char temp = charB[bRemove];
                    charB[bRemove] = charB[aRemove];
                    charB[aRemove] = temp;
                }
            }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new Leetcode854H().kSimilarity("aabbccddee","cdacbeebad"));
    }
}