class FreqStack {
    HashMap<Integer,Integer> hm;
    HashMap<Integer,Stack<Integer>> sm;
    int max=0;
    public FreqStack() {
        hm= new HashMap<>();
        sm=new HashMap<>();
        
    }
    public void push(int val) {
        if(hm.containsKey(val))
        {
            hm.put(val,hm.get(val)+1);
        }
        else
        {
            hm.put(val,1);
        }
        int res=hm.get(val);
        if(res>max)
        {
            max=res;
        }
        if(sm.containsKey(res))
        {
            Stack<Integer> temp= sm.get(res);
            temp.add(val);
            sm.put(res,temp);
        }
        else
        {
            Stack<Integer> st = new Stack<>();
            st.push(val);
            sm.put(res,st);
        }
                //sm.computeIfAbsent(res, z-> new Stack()).push(val);

        
    }
    
    public int pop() {
        int ans= sm.get(max).pop();
        hm.put(ans,hm.get(ans)-1);
        if(sm.get(max).size()==0)
        {
            max--;
        }
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */