package knapsackVariations;
// you have an array and you have to find number of subsets which are equal to sum i.e.; if arr = [2 6 5 8 10]  and sum = 10
// then subsets are [2 8] , [5 2 3] , [10] so 3 subsets are present
public class countOfSubset {
    // using dp
    public static int countOfSubset(int[] arr, int sum, int n, int[][] dp){
        if(sum == 0) return 1;
        if(n == 0) return 0;
        if(dp[n][sum] != -1) return dp[n][sum];
        if(arr[n-1] <= sum){
            return dp[n][sum] = countOfSubset(arr, sum-arr[n-1], n-1, dp) + countOfSubset(arr, sum, n-1, dp);
        }
        else return dp[n][sum] = countOfSubset(arr, sum, n-1, dp);
    }
    // using recursion 
    public static int countOfSubset(int[] arr, int sum, int n){
        if(sum == 0) return 1;
        if(n == 0) return 0;
        if(arr[n-1] <= sum){
            return countOfSubset(arr, sum-arr[n-1], n-1) + countOfSubset(arr, sum, n-1);
        }
        else return countOfSubset(arr, sum, n-1);
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 8, 10};
        int sum = 10;
        int n = arr.length;
        // int[][] dp = new int[n+1][sum+1];
        // for(int i = 0; i < n+1; i++){
        //     for(int j = 0; j < sum+1; j++){ 
        //         dp[i][j] = -1;
        //     }
        // }
        // System.out.println(countOfSubset(arr, sum, n, dp));
        System.out.println(countOfSubset(arr, sum, n));
    }
}
