class Solution {
    /*public void rotate(int[] nums, int k) {
        int []arr = new int[nums.length];
        for(int i = 0 ; i < nums.length;i++)
        {
            arr[(i + k) % nums.length] = nums[i];
        }
        for(int i = 0; i < nums.length;i++)
            nums[i] = arr[i];
    }*/
    public void reverse(int[]nums, int l ,int r)
    {
        while(l <r )
        {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
             r--;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse (nums,k,nums.length-1);
    }
}