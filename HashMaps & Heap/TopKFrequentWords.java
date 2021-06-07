class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<words.length;i++)
        {
            if(hm.containsKey(words[i]))
            {
                hm.put(words[i],hm.get(words[i])+1);
            }
            else
            {
                hm.put(words[i],1);
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
         return hm.get(a)==hm.get(b)?b.compareTo(a):hm.get(a)-hm.get(b);
        });
        
            for(String word:hm.keySet())
            {
                pq.add(word);
                if(pq.size()>k)
                    pq.poll();
            }
        ArrayList<String> ar = new ArrayList<>();
        while(!pq.isEmpty()){
            String str=pq.poll();
            ar.add(str);
        }
        Collections.reverse(ar);
        return ar;
}
}