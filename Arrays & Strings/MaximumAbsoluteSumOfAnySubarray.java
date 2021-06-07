class Solution {
    public int maxAbsoluteSum(int[] nums) {
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
        csum = 0;
        int minsum = (int)1e9;
        for(int i : nums)
        {
            csum += i;
            if(csum <= minsum)
            {
                minsum = csum;
            }
            if(csum > 0)
                csum = 0;
        }
        return Math.max(maxsum,Math.abs(minsum));
    }
}