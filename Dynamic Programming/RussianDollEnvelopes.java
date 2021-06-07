class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for(int i = 0;i < envelopes.length ;i++){
            for(int j = 0;j < envelopes[0].length; j++){
                System.out.println(envelopes[i][j]);
            }
        }
        int dp[] = new int[envelopes.length];
        int ans = 1;
        dp[0] = 1;
        for(int i =1;i < envelopes.length; i++){
            dp[i] = 1;
            for(int j = i - 1;j >= 0;j--){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]  ){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
        }
        for(int i = 0;i < dp.length; i++){
            System.out.print(dp[i]);
            if(ans < dp[i]){
                ans = dp[i];
            }
        }
        return ans;
    }
}