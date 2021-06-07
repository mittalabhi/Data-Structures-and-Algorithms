class Solution {
    public int firstOccurence(int nums[],int target){
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                if(mid - 1 >= 0 && nums[mid - 1] >= target){
                    hi = mid -1 ;
                }
                else{
                    return mid;
                }
            }
            else if(target > nums[mid]){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
        }
        return -1;
    }
    public int lastOccurence(int nums[],int target){
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == target){
                if(mid + 1 <= nums.length - 1 && nums[mid + 1] <= target){
                    lo = mid + 1;
                }
                else{
                    return mid;
                }
            }
            else if(target > nums[mid]){
                lo = mid + 1;
            }
            else{
                hi = mid -1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = firstOccurence(nums,target);
        ans[1] = lastOccurence(nums,target);
        return ans;
    } 
}