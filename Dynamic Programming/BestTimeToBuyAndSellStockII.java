class Solution {
    public int maxProfit(int[] prices) {
        int b = 0;
        int s = 0;
        int ans = 0;
        
        for(int i = 0;i < prices.length - 1;i++){
            if(prices[i + 1] > prices[i]){
                s = s + 1; 
            }
            else
            {
                ans += prices[s] - prices[b];
                b = s = i + 1;
            }
        }
        ans += prices[s] - prices[b];
        return ans;
    }
}