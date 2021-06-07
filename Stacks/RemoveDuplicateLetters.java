class Solution {
    public String removeDuplicateLetters(String s) {
        
       int []freq=new int[26];
        for(int i=0;i<s.length();i++)
        {
            char ch= s.charAt(i);
            freq[ch-'a']++;
        }
        
        Stack<Character> st= new Stack<>();
        
        boolean isVisited[]= new boolean[26];
        
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            freq[ch-'a']--;
            if(isVisited[ch-'a']==true)
                continue;
            
            while(st.size()!=0 && ch<st.peek() && freq[st.peek()-'a']>0)
            {
                isVisited[st.peek()-'a']=false;
                st.pop();
            }
            isVisited[ch-'a']=true;
            st.push(ch);
       }
        StringBuilder str = new StringBuilder();
        
        while(st.size()!=0)
        {
            str.append(st.pop());
        }
        return str.reverse().toString();
        
    }
}

