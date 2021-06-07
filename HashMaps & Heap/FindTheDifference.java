class Solution {
    public char findTheDifference(String s, String t) {
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(int i=0;i<t.length();i++)
        {
            char ch=t.charAt(i);
            
            if(hm.containsKey(ch))
                hm.put(ch,hm.get(ch)+1);
            else
                hm.put(ch,1);
        }
        
        for(int i=0;i<s.length();i++)
        {
            char ch= s.charAt(i);
            if(hm.containsKey(ch))
            {
                if(hm.get(ch)==1)
                {
                    hm.remove(ch);
                }
                else
                {
                    hm.put(ch,hm.get(ch)-1);
                }
            }
        }
        char ans=' ';
        for(Character c:hm.keySet())
        {
            ans=c;
        }
        return ans;
    }
}