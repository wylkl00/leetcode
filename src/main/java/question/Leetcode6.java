package question;

import javax.swing.text.Position;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Description:
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author wangyang
 * @since 2019/1/7
 */

public class Leetcode6 {

    public static String convert(String s, int numRows) {
        final int circle = 2 * numRows - 2 ;
        if (circle < 2){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int position = 0;

        while (position < s.length()){
            sb.append(s.charAt(position));
            position += circle;
        }

        int i;
        for ( i = 1; i <= numRows - 2; i++){
            int position1 = i;
            int position2 = circle - i;
            while (position1 < s.length()){
                sb.append(s.charAt(position1));
                position1 += circle;
                if (position2 < s.length()){
                    sb.append(s.charAt(position2));
                    position2 += circle;
                }
            }
        }
        position = i;
        while (position < s.length()){
            sb.append(s.charAt(position));
            position += circle;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("A" , 2));
    }
}