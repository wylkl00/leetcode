package question;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * @author wangyang
 * @since 2019/2/18
 */

public class Leetcode52H {

    private int[] queenPlace;
    private int scale;

    public int totalNQueens(int n) {
        queenPlace = new int[n];
        scale = n;
        int col = 0;
        int result = 0;
        while (set(col)) {
            if (col == n - 1){
                result++;
            }else{
                col++;
            }
        }
        return result;
    }

    private boolean set (int col){
        if (col < 0 ) return false;
        do{
            if (queenPlace[col] >= scale){
                queenPlace[col] = 0;
                if (!set(col-1)) return false;
            }
            queenPlace[col]++;
        }while(!check(col));
        return true;
    }

    private boolean check (int n){
        for(int i = 0; i< n ; i++){
            if (queenPlace[i] == queenPlace[n]) return false;
            if (Math.abs(queenPlace[i] - queenPlace[n]) == n-i) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Leetcode52H().totalNQueens(13));
    }
}
