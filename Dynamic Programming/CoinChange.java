class Solution {
   public int minCoinsRequired(int[] arr, int tar,int[] dp) {
        if(tar == 0){
            return 0;
        }

        if(dp[tar] != -1) return dp[tar];

        int minCoin = (int)1e9;
        for(int ele : arr){
            if(tar - ele >= 0 ){
                int val = minCoinsRequired(arr,tar - ele,dp);
                if(val != (int)1e9 && val + 1 < minCoin)
                   minCoin = val + 1;
            }
        }

        return dp[tar] = minCoin;
    }
public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,-1);

        int ans = minCoinsRequired(coins,amount,dp);
        return ans != (int)1e9? ans: -1;
    }
}