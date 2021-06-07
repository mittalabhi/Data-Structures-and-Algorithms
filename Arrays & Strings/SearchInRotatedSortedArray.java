class Solution {
    public int search(int[] nums, int data) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] == data) return mid;
            else if(nums[lo] <=  nums[mid]){
                if(data >= nums[lo] && data < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            }
            else{
                if(data > nums[mid] && data <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}