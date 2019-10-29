package programs.arrays;

public class ArraySumSubset {

    private static int getmNumberOfSubsets(int[] numbers, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        int currentSum =0;
        for (int i = 0; i < numbers.length; i++) {
            currentSum += numbers[i];
            for (int j = Math.min(sum, currentSum); j >= numbers[i]; j--) {
                dp[j] += dp[j - numbers[i]];
                System.out.print(j+" "+"dp[j]: "+dp[j]+" ");
            }
            System.out.println();
        }

        return dp[sum];
    }
    private static int subsetSum(int[] input, int total) {

        int[][] dp = new int[input.length + 1][total + 1];
        for (int i = 0; i <= input.length; i++) {
           dp[i][0] = 1;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - input[i - 1] >= 0) {
                   dp[i][j] = (dp[i - 1][j]) + (dp[i - 1][j - input[i - 1]]);
                } else {
                   dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[input.length][total];

    }

    public static void main(String[] args){
        int[] arr = {2,4,6,10,11};
        int sum = 13;
        System.out.println(subsetSum(arr,sum));
    }
}
