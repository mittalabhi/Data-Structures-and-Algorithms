class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int c = nums.length / 2;
        for(int i = 0 ;i < nums.length;i++)
        {
           
            if(hm.containsKey(nums[i]))
            {
                hm.put(nums[i],hm.get(nums[i]) + 1);
                
            }
            else 
            {
                hm.put(nums[i],1);
            }
             if(hm.get(nums[i]) > c)
                return nums[i];
        }
        return 0;
    }
}