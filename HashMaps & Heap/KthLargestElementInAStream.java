class KthLargest {
    int k;
            PriorityQueue<Integer> pq=new PriorityQueue<>();


    public KthLargest(int k, int[] nums) {
        
        for(int i:nums)
        {
            pq.add(i);
        }
        this.k=k;
        
    }
    public int add(int val) {
        pq.add(val);
        int c=k;
        while(pq.size()>c)
        {
            pq.poll();
            //c--;
        }
        return pq.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */