class Solution {
    public boolean canFinish(int piles[],int H,int speed){
        int time = 0;
        for(int i = 0;i < piles.length; i++){
            if(piles[i] <= speed) time += 1;
            else{
                if(piles[i] % speed == 0){
                    time += piles[i] / speed;
                } 
                else{
                    time += (piles[i] / speed) + 1;
                }
            }
        }
        return time <= H ? true : false;
    }
    public int minEatingSpeed(int[] piles, int H) {
        int min = 1;
        int max = (int)1e9 + 1;
        int ans = 0;
        while(min < max){
            int mid = min + (max - min) / 2;
            boolean finish = canFinish(piles,H,mid);
            if(finish){
                max = mid;
                ans = mid;
            }
            else{
                min = mid + 1;
            }
        }
        return ans;
    }
}
