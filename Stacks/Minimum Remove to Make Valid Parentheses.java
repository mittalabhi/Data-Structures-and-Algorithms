class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr=s.toCharArray();
        
        Stack<Integer> st= new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                st.push(i);
            }
            else if(ch==')')
            {
                if(st.size()==0)
                {
                    arr[i]='@';
                }
                else 
                    st.pop();
            }
        }

        if(st.size()!=0)
        {
            while(st.size()!=0)
            {
                arr[st.peek()]='@';
                st.pop();
            }
        }
            String ans="";
            for(int i=0;i<arr.length;i++)
            {
                if(arr[i]!='@')
                 ans+=arr[i];
            }
            return ans;
            
                
                
            
        }
        
    }
