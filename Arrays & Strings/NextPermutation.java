class Solution {
    public void reverse(int[] nums,int i,int j){
        while(i < j)
        {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int idx = -1;
        for(int i = nums.length - 1;i > 0;i--){
            if(nums[i] > nums[i - 1])
            {
                idx = i;
                break;
            }
        }
        System.out.print(idx);
        if(idx == -1)
        {
            reverse(nums,0,nums.length - 1);
        }
        else{
            int prev = idx;
            for(int i = idx + 1; i < nums.length;i++)
            {
                if(nums[i] > nums[idx - 1] && nums[i] <= nums[prev]){
                    prev = i;
                }
            }
            int temp = nums[idx - 1];
            nums[idx - 1] = nums[prev];
            nums[prev] = temp;
            reverse(nums,idx,nums.length - 1);
        }
    }
}