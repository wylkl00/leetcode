package question;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
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
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * @author wangyang
 * @since 2019/2/18
 */

public class LeetCode51H {
    private int[] queenPlace;

    public List<List<String>> solveNQueens(int n) {
        queenPlace = new int[n];
        int col = 0;
        List<List<String>> result = new ArrayList<>();
        while (set(col,n)) {
            if (col == n - 1){
                List<String> list = new ArrayList<>();
                for (int i = 0; i < n; i++){
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0 ; j < queenPlace[i] -1 ; j++ ){
                        sb.append('.');
                    }
                    sb.append('Q');
                    for (int k = queenPlace[i] ; k < n ; k++ ){
                        sb.append('.');
                    }
                    list.add(sb.toString());
                }
                result.add(list);
            }else{
                col++;
            }
        }
        return result;
    }

    private boolean set (int col, int n){
        if (col < 0 ) return false;
        do{
            if (queenPlace[col] >= n){
                queenPlace[col] = 0;
                if (!set(col-1, n)) return false;
            }
            queenPlace[col]++;
        }while(!check(col));
        return true;
    }

    private boolean check (int n){
        for(int i = 0; i<n ; i++){
            if (queenPlace[i] == queenPlace[n]) return false;
            if (Math.abs(queenPlace[i] - queenPlace[n]) == n-i) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode51H().solveNQueens(8).size());
    }
}
