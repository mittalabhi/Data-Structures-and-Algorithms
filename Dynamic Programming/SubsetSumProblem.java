public class Solution {
    public int subsequenceDP(int[] arr,int idx,int target,int sum,int[][] dp){
   if(target == 0 || idx == arr.length){
            return target == 0 ? 1 : 0; 
        }
        if(dp[idx][target] != -1) return dp[idx][target];

        boolean res = false;
        if(target - arr[idx] >= 0)
            res = res || subsequenceDP(arr,idx + 1,target - arr[idx], sum + arr[idx],dp) == 1;

        res = res || subsequenceDP(arr,idx + 1,target,sum,dp) == 1;

        return dp[idx][target] = res == true ? 1 : 0;
    }
    public int solve(int[] A, int B) {

        int dp[][] = new int[A.length + 1][B + 1];
        for(int ar[]:dp)Arrays.fill(ar,-1);
        int ans = subsequenceDP(A,0,B,0,dp);
        return ans;
    }
}
