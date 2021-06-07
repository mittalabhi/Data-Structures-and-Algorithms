class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
        public static long merge(long[] nums,int si,int mid,int ei)
    {
        long count = 0;
        long []left = new long[mid - si + 1];
        long []right = new long[ei - mid];
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
                count += mid - i;
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
        return count;
    }
    public static long mergeSort(long []nums,int si,int ei)
    {
        long count = 0;
        if(si < ei)
        {
            int mid = (si + ei) / 2;
            count += mergeSort(nums,si,mid);
            count+= mergeSort(nums,mid + 1,ei);
            count+= merge(nums,si,mid,ei);
        }
        return count;
    }
    static long inversionCount(long nums[], long N)
    {
        // Your Code Here
        return mergeSort(nums,0,nums.length-1);
    }