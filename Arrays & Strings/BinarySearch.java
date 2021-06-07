class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int high = nums.length - 1;
        while(lo <= high){
            int mid = (lo + high) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(target > nums[mid]){
                lo = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}