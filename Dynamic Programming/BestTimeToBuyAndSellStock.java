class Solution {
    public int bruteMethod(int[] prices){
        int ans = 0;
        
        for(int i = 0;i < prices.length;i++){
            int max = prices[i];
            for(int j = i + 1;j < prices.length;j++){
                if(prices[j] > max){
                    max = prices[j];
                }
            }
            ans = Math.max(ans,max - prices[i]);
        }
        return ans;
    }
    
    public int betterMethod(int[] prices){
        int maxValue[] = new int[prices.length];
        int max = prices[prices.length - 1];
        
        for(int i = prices.length - 1;i >= 0;i--){
            max = Math.max(max,prices[i]);
            maxValue[i] = max;
        }
        int ans = 0;
        for(int i = 0;i < prices.length;i++){
            ans = Math.max(ans,maxValue[i] - prices[i]);
        }
        return ans;
    }
    
    public int OptimizedMethod(int[] prices){
        int min = prices[0];
        int ans = 0;
        for(int i = 0;i < prices.length;i++){
            min = Math.min(min,prices[i]);
            ans = Math.max(ans,prices[i] - min);
        }
        return ans;
    }
    public int maxProfit(int[] prices) {
      //int ans = bruteMethod(prices);
     // int ans = betterMethod(prices);
        
        int ans = OptimizedMethod(prices);
        
        return ans;
        
    }
}