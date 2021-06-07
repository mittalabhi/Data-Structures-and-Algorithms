class Solution {
    public int smallerOnLeft(int[] input) {
        
        Stack<Integer> st1=new Stack<>();
      

        int arr1[]= new int[input.length];
        Arrays.fill(arr1,input.length);
        st1.push(0);
        //nextsmaller element on left
        for(int i=input.length-1;i>=0;i--)
        {
            while(st1.size()!=0 && input[i]<input[st1.peek()])
            {
                arr1[st1.peek()]=i;
                st1.pop();
            }
            st1.push(i);
        }
        return arr1;
        
        
    }
}