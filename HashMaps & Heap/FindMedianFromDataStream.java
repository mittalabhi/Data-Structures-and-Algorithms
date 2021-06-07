class MedianFinder {
    PriorityQueue<Integer> leftMax;
    PriorityQueue<Integer> rightMin;
    /** initialize your data structure here. */
    public MedianFinder() {
        leftMax= new PriorityQueue<>((a,b)->{return b-a;});
        rightMin= new PriorityQueue<>((a,b)->{return a-b;});
    }
    
    public void addNum(int num) {
        if(leftMax.size()==0 || num<leftMax.peek())
        {
            leftMax.add(num);
        }
        else
        {
            rightMin.add(num);
        }
        if(rightMin.size()-leftMax.size()==2)
        {
            leftMax.add(rightMin.poll());
        }
        else if(leftMax.size()>rightMin.size() && leftMax.size()>1)
        {
            rightMin.add(leftMax.poll());
        }
    }
    
    public double findMedian() {
        if(leftMax.size()==1 && rightMin.size()==0)
            return leftMax.peek();
        if((leftMax.size()+rightMin.size())%2==0)
        {
            return((leftMax.peek()+rightMin.peek())/2.0);
        }
        return rightMin.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */