class Solution {
    PriorityQueue<Double> leftMax = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Double> rightMin = new PriorityQueue<>();
    public double[] medianSlidingWindow(int[] nums, int k) {
        if(k == 1){
            double ans[] = new double[nums.length];
            int i = 0;
            for(int ele: nums){
                ans[i++] = (double)ele;
            }
            return ans;
        }
        int si = 0;
        int ei = 0;
        int n = nums.length;
        int j = 0;
        double res[] = new double[nums.length - k + 1];
        while(ei < n){
            
            addNum((double)nums[ei++]);
            if(ei - si > k){
                removeData((double)nums[si++]);
                
            }
            if(ei - si == k){
                res[j++] = findMedian();
            }
        }
        return res;
    }
    public void removeData(double data){
        if(data <= leftMax.peek()){
            leftMax.remove(data);
        }
        else{
            rightMin.remove(data);
        }
        heapBalancing();
    }
    public void addNum(double num) {
        if(leftMax.size() == 0 || num < leftMax.peek() ){
            leftMax.add(num);
        }
        else{
            rightMin.add(num);
        }
        heapBalancing();   
    }
    public void heapBalancing(){
        if(leftMax.size() - rightMin.size() > 1){
            rightMin.add(leftMax.poll());
        }
        else if(rightMin.size() - leftMax.size() > 1){
            leftMax.add(rightMin.poll());
        }
    }
    public double findMedian() {
        double res = 0.0;
        if(leftMax.size() > rightMin.size()){
            res = (double)leftMax.peek();
        }
        else if(leftMax.size() < rightMin.size()){
            res = (double)rightMin.peek();
        }
        else {
            res = (leftMax.peek() + rightMin.peek()) * 0.5;
        }
        return res;
    }
}