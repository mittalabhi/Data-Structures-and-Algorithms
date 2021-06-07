class Solution {
    public int longestOnes(int[] nums, int k) {
        int si = 0;
        int ei = 0;
        int len = nums.length;
        int ans = 0;
        int noOfZeroes = 0;
        int count = 0;
        while(ei < len){
            if(nums[ei] == 0){
                noOfZeroes++;
            }
            ei++;
            while(noOfZeroes > k){
                if(nums[si] == 0){
                    noOfZeroes--;
                }
                si++;
            }
            ans = Math.max(ans,ei-si);

        }
        return ans;
    }
}
