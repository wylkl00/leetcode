package question;

/**
 * Description:
 *
 * @author wangyang
 * @since 2022/3/6
 */

public class MinLength {

    public int minPathSum(int[][] grid) {
        int [][] minMap = new int[grid.length][grid[0].length];


        for (int i = 0; i< grid.length;i++ ){

            for (int j = 0; j< grid[0].length;j++ ){

                if (i == 0 && j==0 ){
                    minMap[i][j] = grid[i][j];
                } else if (i ==0){
                    minMap[i][j] = grid[i][j] + minMap[i][j-1];
                } else if (j == 0){
                    minMap[i][j] = grid[i][j] + minMap[i-1][j];
                } else{
                    minMap[i][j] = Math.min( minMap[i-1][j],  minMap[i][j-1]) + grid[i][j];
                }

            }
        }

        return minMap[grid.length-1][grid[0].length-1];
    }



    public static void main(String[] args) {
        int [] [] grid = {{1,2,3},{4,5,6}};
        System.out.println(new MinLength().minPathSum( grid));
    }


}
