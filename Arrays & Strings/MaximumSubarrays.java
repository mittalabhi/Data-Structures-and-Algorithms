class Solution {
    public int maxSubArray(int[] nums) {
        int csum = 0;
        int maxsum = -(int)1e9;
        for(int i : nums)
        {
            csum += i;
            if(csum >= maxsum)
            {
                maxsum = csum;
            }
            if(csum < 0)
                csum = 0;
        }
        return maxsum;
    }
}