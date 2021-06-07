class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int arr[]= new int[2*nums.length];
        
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=nums[i];
        }
        for(int i=nums.length,j=0;i<arr.length;i++,j++)
        {
            arr[i]=nums[j];
        }
        
        int ans[]=new int[2*nums.length];
        Stack<Integer> st=new Stack<>();
        Arrays.fill(ans,-1);
        st.push(0);
        for(int i=0;i<arr.length;i++)
        {
            while(st.size()!=0&&arr[i]>arr[st.peek()])
            {
                ans[st.peek()]=arr[i];
                st.pop();
            }
            st.push(i);
            
            
        }
        int res[]=Arrays.copyOfRange(ans,0,ans.length/2);
        return res;
        
        
        
    }
}