class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> {
            return a[0] - b[0];
        });
        int dp[] = new int[pairs.length];
        Arrays.fill(dp,1);
        int ans = 1;
        for(int i = 0;i < dp.length;i++){
            for(int j = 0;j < i;j++){
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    if(dp[i] > ans) ans = dp[i];
                }
            }
        }
        return ans;
    }
}