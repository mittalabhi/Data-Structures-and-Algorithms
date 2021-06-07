class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hm= new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(hm.containsKey(ch))
            {
                hm.put(ch,hm.get(ch)+1);
            }
            else
                hm.put(ch,1);
        }
        PriorityQueue<int []> pq= new PriorityQueue<>((a,b)->{
            return b[1]-a[1];
        });
        for(int i=0;i<s.length();i++)
        {
            char ch= s.charAt(i);
            int val=(int)ch;
            if(hm.containsKey(ch))
            {
                pq.add(new int[] {val,hm.get(ch)});
                hm.remove(ch);
            }   
        }
        
        StringBuilder st= new StringBuilder();
        
        
        while(!pq.isEmpty())
        {
            int[] arr=pq.poll();
            for(int i=0;i<arr[1];i++)
            {
                st.append((char)arr[0]);
            }
            
            
        }
        return st.toString();
    }
}