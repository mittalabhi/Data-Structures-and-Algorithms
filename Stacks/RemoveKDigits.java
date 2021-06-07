class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length()==k)
            return "0";
        
        Stack<Character> st = new Stack<>();
        
        
        for(int i=0;i<num.length();i++)
        {
            while(st.size()!=0 && k>0 && (num.charAt(i))<st.peek())
            {
                st.pop();
                k--;
                
            }
            st.push(num.charAt(i));
            
        
            
        }
        while(k!=0)
        {
            st.pop();
            k--;
        }
        
        
    StringBuilder sb= new StringBuilder();
        
        while(st.size()!=0)
        {
            sb.append(st.pop());
            
        }
        sb.reverse();
        while(sb.charAt(0)=='0' && sb.length()>1)
        {        

            sb.deleteCharAt(0);
            
        }
            
        
        return sb.toString();
        
        
        
    }
}