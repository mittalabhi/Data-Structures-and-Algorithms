class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0 ,j=0;i<pushed.length&&j<popped.length;i++)
        {
            st.push(pushed[i]);
            while(st.size()!=0 && st.peek()==popped[j])
            {
                st.pop();
                j++;
            }
        }
        if(st.size()==0)
            return true;
        else 
            return false;
        
    }
}