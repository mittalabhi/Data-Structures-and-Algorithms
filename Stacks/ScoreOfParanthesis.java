class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<S.length();i++)
        {
            char ch=S.charAt(i);
            
            if(ch=='(')
            {
                st.push(0);
            }
            else  //ch==")"
            {
                if(st.peek()==0)
                {
                    st.pop();
                    st.push(1);
                }
                else
                {
                    int sum=0;
                    while(st.peek()!=0)
                    {
                        sum+=st.peek();
                        st.pop();
                    }
                    st.pop();
                    st.push(2*sum);
                }
                
            }
        }
        int score =0;
        while(!st.isEmpty())
        {
            score+=st.peek();
            st.pop();
        }
        return score;
        
    }
}