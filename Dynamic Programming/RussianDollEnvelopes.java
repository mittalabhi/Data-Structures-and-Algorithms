class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr,(a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int dp[] = new int[arr.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1;i < arr.length;i++){
            for(int j = 0;j < i;j++){
                if(arr[i][1] > arr[j][1] && arr[i][0] != arr[j][0]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    if(dp[i] > max) max = dp[i];
                }
            }
        }
        return max;
    }
}