class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int arr[] = new int[nums.length];
        Stack<Integer>st=new Stack<>();
        Arrays.fill(arr,nums.length);
        st.push(0);
        for(int i=1;i<nums.length;i++)
        {
            while(st.size()!=0&&nums[i]>nums[st.peek()])
            {
                arr[st.peek()]=i;
                st.pop();
            }
            st.push(i);
        }
        
        int ans[]= new int[nums.length-k+1];
        int j=0;
        for(int i=0;i<nums.length-k+1;i++)
        {
            if(j<i)
                j=i;
            if(arr[j]<i+k)
            {
                while(arr[j]<i+k)
            {
                j=arr[j];                
                ans[i]=nums[j];
            }
            }
        
            else
            ans[i]=nums[j];
           
        }
        return ans;
    }
}