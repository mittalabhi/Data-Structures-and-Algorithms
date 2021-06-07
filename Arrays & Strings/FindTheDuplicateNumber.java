class Solution {
    public int findDuplicate(int[] nums) {
        int ans=0;
        int n= nums.length;
        
        boolean isVisited[]=new boolean[n];
        
        for(int i=0;i<n;i++)
        {
            
            if(!isVisited[nums[i]])
            {
                isVisited[nums[i]]=true;
            }
            else
            {
                ans=nums[i];
            }
        }
        return ans;
    }
}