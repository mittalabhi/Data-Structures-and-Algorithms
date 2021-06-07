class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void swap(int idx1,int idx2,int nums[]){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
    public void permute(int nums[],int start,int end){
        if(start >= end){
            List<Integer> smallAns = new ArrayList<>();
            for(int i = 0;i < nums.length; i++){
                smallAns.add(nums[i]);
            }
            res.add(smallAns);
            return;
        }
        for(int i = start; i <= end; i++){
            swap(start,i,nums);
            permute(nums,start + 1,end);
            swap(start,i,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        permute(nums,0,nums.length - 1);
        return res;
    }
}
