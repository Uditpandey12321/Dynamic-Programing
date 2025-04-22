package knapsackVariations;

public class knapsack01 {
    // using recursive approach
    public static int knapsack(int[] wt,int[] val, int w, int n){
        if(n==0 || w == 0){
            return 0;
        }
        if (wt[n-1] <= w) {
            return Math.max((val[n-1] + knapsack(wt, val, w-wt[n-1], n-1)),knapsack(wt, val, w, n-1));
        }
        return knapsack(wt, val, w, n-1);
    }
    // using memoization  
    public static int knapsackmemo(int[] wt, int[] val, int w, int n, int[][] dp) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (dp[n][w] != -1) { // Fixed condition
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            return dp[n][w] = Math.max(
                val[n - 1] + knapsackmemo(wt, val, w - wt[n - 1], n - 1, dp),
                knapsackmemo(wt, val, w, n - 1, dp)
            );
        }
        return dp[n][w] = knapsackmemo(wt, val, w, n - 1, dp);
    }
    
    

    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] val = {1,4,5,7};

        int w = 7;
        int n = wt.length;
        System.out.println(knapsack(wt, val, w, n));

        int[][] dp = new int[n+1][w+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackmemo(wt, val, w, n, dp));

    }
}
