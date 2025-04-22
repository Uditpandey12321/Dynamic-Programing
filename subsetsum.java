package knapsackVariations;
// subset sum is a variation of knapsack
// we have input of array and value of sum 
// have to find the presence of the subset in array whose
// sum is eqaul to provided value of sum
public class subsetsum {
    // using recursion
    public static boolean issubset(int[] arr, int sum, int n) {
        // Base cases
        if (sum == 0) return true; 
        if (n == 0) return false;  
    
        if (arr[n - 1] <= sum) {
            return issubset(arr, sum - arr[n - 1], n - 1) || issubset(arr, sum, n - 1);
        } else {
            return issubset(arr, sum, n - 1);
        }
    }
    // using memoization
    public static boolean issubsetMemo(int[] arr, int sum, int n, Boolean[][] dp) {
        if (sum == 0) return true;
        if (n == 0) return false;
    
        if (dp[n][sum] != null) return dp[n][sum]; // 💡 Memoization check
    
        if (arr[n - 1] <= sum) {
            dp[n][sum] = issubsetMemo(arr, sum - arr[n - 1], n - 1, dp) ||
                         issubsetMemo(arr, sum, n - 1, dp);
        } else {
            dp[n][sum] = issubsetMemo(arr, sum, n - 1, dp);
        }
        return dp[n][sum];
    }
    // using bottom up approach
    public static boolean issubsetDP(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
    
        for (int i = 0; i <= n; i++) dp[i][0] = true;
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    
        return dp[n][sum];
    }
         
    
    public static void main(String[] args) {
        int [] arr = {2,3,7,8,10};
        int sum = 11;
        int n = arr.length;
        System.out.println(issubset(arr, sum, n)); 
    }
}
