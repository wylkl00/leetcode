package question;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Description: 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
 *
 *
 *
 * American keyboard
 *
 *
 *
 * 示例：
 *
 * 输入: ["Hello", "Alaska", "Dad", "Peace"]
 * 输出: ["Alaska", "Dad"]
 *
 *
 * 注意：
 *
 * 你可以重复使用键盘上同一字符。
 * 你可以假设输入的字符串将只包含字母。
 *
 * @author wangyang
 * @since 2019/5/7
 */

public class Leetcode500E {
        public String[] findWords(String[] words) {
            char[] line1 ="qwertyuiop".toCharArray();
            char[] line2 ="asdfghjkl".toCharArray();
            char[] line3 ="zxcvbnm".toCharArray();
            HashMap<Character, Integer> map = new HashMap<>();
            for (char letter: line1){
                map.put(letter,1);
            }
            for (char letter: line2){
                map.put(letter,2);
            }
            for (char letter: line3){
                map.put(letter,3);
            }
            ArrayList<String> result= new ArrayList<>();
            for (String word : words){
                int line = map.get(Character.toLowerCase(word.charAt(0)));
                boolean complete = true;
                for (int i= 1 ; i<word.length(); i++){
                    if (map.get(Character.toLowerCase(word.charAt(i))) != line){
                        complete = false;
                        break;
                    }
                }
                if (complete){
                    result.add(word);
                }
            }

            return result.toArray(new String[0]);
        }

    public static void main(String[] args) {
        System.out.println( new Leetcode500E().findWords(new String[]{"Hello","Alaska","Dad","Peace"}));
    }
}
