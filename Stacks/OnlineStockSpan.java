class StockSpanner {
    
    Stack<int[] > st = new Stack<>();
    int idx=0;

    public StockSpanner() {
        st.push(new int[]{-1,-1});
        
        
    }
    
    public int next(int price) {
        
        while(st.size()!=1 && price>=st.peek()[1]){
            st.pop();
            
        }
        int span=idx-st.peek()[0];
        st.push(new int[]{idx,price});
        idx++;

        return span;
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */