package programs.matrix;


public class MinumPathSum {

    //1. calculate sum of first row
    //2. calculate sum of first column
    //3. d[row] [column] = cost[row] [column] + min(dp[row][column-1]+dp[row-1][column]) starting from 2 row and column till end
    //4. dp[row] [column] will have the minimum cost to reach from left to right
     private int minCost(int[][] cost,int m,int n){

        int[][] dp = new int[m+1][n+1];
        int sum = 0;
        for(int i=0; i <= n; i++){
            dp[0][i] = sum + cost[0][i];
            sum = dp[0][i];
        }
        sum = 0;
        for(int i=0; i <= m; i++){
            dp[i][0] = sum + cost[i][0];
            sum = dp[i][0];
        }


        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                dp[i][j] = cost[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }



    public static void main(String[] args){
        MinumPathSum mcp = new MinumPathSum();
        int[][] cost = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
                };
        int row = 2;
        int column = 2;
        int result = mcp.minCost(cost, row, column);
        System.out.println(result);
    }


}
