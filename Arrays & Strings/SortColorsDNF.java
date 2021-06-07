class Solution {
    public void sortColors(int[] nums) {
        int p1 = -1;
        int p2 = nums.length - 1;
        int idx = 0;
        while(idx <= p2){
            if(nums[idx] == 0){
                swap(nums,++p1,idx++);
            }
            else if(nums[idx] == 2){
                swap(nums,idx,p2--);
            }
            else{
                idx++;
            }
        }
    }
    public void swap(int nums[],int idx1,int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;

    }
}
