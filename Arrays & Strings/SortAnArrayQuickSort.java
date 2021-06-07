//quick sort is O(nlogn) with maximum priority using randomized pivotand it uses O(1) space......worst case is O(n^2)
class Solution {
    public int partition(int [] nums,int si,int ei){
        int pivot = ei;
        int idx = si;
        for(int i = si;i < ei; i++){
            if(nums[i] < nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                idx++;
            }
        }
        int temp = nums[pivot];
        nums[pivot] = nums[idx];
        nums[idx] = temp;
        return idx;
    }
    public void sortArrayHelper(int nums[],int si,int ei){
        if(si >= ei) return;
        int idx = partition(nums,si,ei);
        sortArrayHelper(nums,si,idx - 1);
        sortArrayHelper(nums,idx + 1,ei);

    }
    public int[] sortArray(int[] nums) {
        sortArrayHelper(nums,0,nums.length - 1);
        return nums;
    }
}