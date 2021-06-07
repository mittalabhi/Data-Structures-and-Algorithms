class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if(hi == 0) return nums[0];
        else if(nums[0] != nums[1]) return nums[0];
        else if(nums[hi] != nums[hi - 1]) return nums[hi];
        
        while(lo <= hi)
        {
            int mid = (lo + hi )/ 2;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            else if( ((mid % 2 == 0) && (nums[mid] == nums[mid + 1]) || ((mid % 2 != 0) && (nums[mid] == nums[mid - 1]))) )
                lo = mid +1;
            else 
                hi = mid - 1;
        }
        return -1;
    }
}