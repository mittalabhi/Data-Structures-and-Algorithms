class Solution {
    public int minAddToMakeValid(String S) {        
        Stack <Character> st = new Stack<>();       
        for(int i=0;i<S.length();i++)
        {
            char ch = S.charAt(i);
            if(st.isEmpty())
            {
                st.push(ch);
                continue;
            }
            if(ch==')')
            {
                if(st.peek()=='(')
                    st.pop();               
                else
                    st.push(ch);                
            }
            else
                st.push(ch);
        }
        return st.size();
        
        
    }
}