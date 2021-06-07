class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder s=new StringBuilder();
        
        int o=0,c=0,start=0;
        for(int i=0;i<S.length();i++)
        {
            char ch=S.charAt(i);
            if(ch=='(')
                o++;
            else if(ch==')')
                c++;
                if(o==c)
                {
                    s.append(S.substring(start+1,i));
                   start =i+1;
                }
        }
        return s.toString();
    }
}