class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length;
        while(lo < hi){
            int mid = (lo + hi) / 2;
            //if(nums[mid] == target) return mid;
            if(target > nums[mid]){
                lo = mid + 1;
            }
            else{
                hi = mid;
            }
        }
        return hi;
    }
}
