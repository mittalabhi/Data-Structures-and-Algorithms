class Solution {
    public int helper(int nums[],int k){
        int si = 0;
        int ei = 0;
        int oddCount = 0;
        int n = nums.length;
        int res = 0;
        while(ei < n){
            if((nums[ei++] & 1) != 0)oddCount++;

            while(oddCount > k){
                if((nums[si++] & 1) != 0)oddCount--;
            }
            res += ei - si;

        }
        return res;

    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }
}
