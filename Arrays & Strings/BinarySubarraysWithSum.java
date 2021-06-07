class Solution {
    public int numSubarraysWithSum(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int count = 0;
        int psum = 0;
        hm.put(0,1);
        for(int i = 0; i < nums.length; i++)
        {
            psum += nums[i];
            if(hm.containsKey(psum - k))
            {
                count = count + hm.get(psum - k);
            }
            if(hm.containsKey(psum))
                hm.put(psum,hm.get(psum)+1);
            else
                hm.put(psum,1);
        }
        return count;
    }
}