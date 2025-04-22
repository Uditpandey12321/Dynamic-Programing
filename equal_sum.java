package knapsackVariations;
// array is given as input and we have to divide it in two subset such that some of both subset is equal 
// if sum is equal then return true otherwise false 
public class equal_sum {
    public static boolean equalsubset(int arr[], int sum,int n){
       if (sum==0) {
        return true;
       }
       for(int i=0;i<n;i++){
        sum = sum+arr[i];

       }
       if (sum %2 !=0) {
        return false;
       }
       return equalsubset(arr,sum/2,n );
    }


    // using dp
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }
  
    public static void main(String[] args) {
        int arr[] = {1,5,11,5};
        int n = arr.length;
        System.out.println(equalsubset(arr,0,n));
    }
}
