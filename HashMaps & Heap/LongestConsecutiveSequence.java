class Solution {
    public int longestConsecutive(int[] nums) {
    
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
            
        {
            hm.put(nums[i],1);
        }
        int len=0;
        for(int i=0;i<nums.length;i++)
        {
            int prev=nums[i]-1;
            int next=nums[i]+1;
            
            while(hm.containsKey(prev))
            {
                hm.remove(nums[i]);
                hm.remove(prev);
                prev--;
            }
            while(hm.containsKey(next))
            {
                hm.remove(nums[i]);
                hm.remove(next);
                next++;
            }
            len=Math.max(len, next-prev-1);
        }
        return len;
    }
    
}