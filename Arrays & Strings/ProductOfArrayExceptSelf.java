class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int []ans = new int[nums.length];
        ans[0] = 1;
        ans[nums.length - 1] = 1;
        for(int i = 1;i < nums.length;i++)
        {
            prod *= nums[i-1];
            ans[i] = prod;
        }
        prod = 1;
        for(int i = nums.length - 2; i >= 0;i--)
        {
            prod *= nums[i + 1];
            ans[i] = ans[i] * prod;
        }
        return ans;
    }
}