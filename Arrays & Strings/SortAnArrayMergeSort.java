class Solution {
    public void merge(int[] nums,int si,int mid,int ei)
    {
        int []left = new int[mid - si + 1];
        int []right = new int[ei - mid];
        int t = 0;
        for(int i = si; i <= mid;i++)
        {
            left[t++] = nums[i];
        }
        t = 0;
        for(int i = mid + 1; i <= ei;i++)
        {
            right[t++] = nums[i];
        }
        int i = 0;
        int j = 0;
        int k = si;
        while(i < left.length && j< right.length)
        {
            if(left[i] <= right[j])
                nums[k++] = left[i++];
            else{
                nums[k++] = right[j++];
            }
        }
        while(i < left.length){
            nums[k++] = left[i++];
        }
        while(j < right.length)
        {
            nums[k++] = right[j++];
        }
    }
    public void mergeSort(int []nums,int si,int ei)
    {
        if(si < ei)
        {
            int mid = (si + ei) / 2;
            mergeSort(nums,si,mid);
            mergeSort(nums,mid + 1,ei);
            merge(nums,si,mid,ei);
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length - 1);
        return nums;
        
    }
}