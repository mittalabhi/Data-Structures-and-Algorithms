class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int dp[][] = new int[n][n];
        return minScoreTriaungulationHelper(values,0,n-1,dp);
    }
    public int minScoreTriaungulationHelper(int values[],int si,int ei,int dp[][]){
        if(si + 1 == ei ){
           return dp[si][ei] = 0;
        }
        if(dp[si][ei] != 0){
            return dp[si][ei];
        }
        int minVal = (int)1e9;
        for(int cut = si + 1;cut < ei; cut++){
            int ans1 = minScoreTriaungulationHelper(values,si,cut,dp);
            int ans2 = minScoreTriaungulationHelper(values,cut,ei,dp);

            minVal = Math.min(minVal,(ans1 + (values[si] * values[cut] * values[ei]) + ans2));

        }
        return dp[si][ei] = minVal;
    }
}
