class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> st1=new Stack<>();
      Stack<Integer> st2=new Stack<>();

        int arr1[]= new int[heights.length];
        int arr2[]= new int[heights.length];
        Arrays.fill(arr1,heights.length);
        Arrays.fill(arr2,-1);
        st1.push(0);
        //next samller on right
        for(int i=0;i<heights.length;i++)
        {
            while(st1.size()!=0 && heights[i]<heights[st1.peek()])
            {
                arr1[st1.peek()]=i;
                st1.pop();
            }
            st1.push(i);
        }
        //nextsmaller element on left
        for(int i=heights.length-1;i>=0;i--)
        {
            while(st2.size()!=0 && heights[i]<heights[st2.peek()])
            {
                arr2[st2.peek()]=i;
                st2.pop();
            }
            st2.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++)
        {
            int width=arr1[i]-arr2[i]-1;
            int area=width*heights[i];
            if(area>max)
                max=area;
        }
        return max;
        
        
    }
}