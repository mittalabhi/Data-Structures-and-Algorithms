class Solution {
    public int smallerOnRight(int[] input) {
        
        Stack<Integer> st1=new Stack<>();
      

        int arr1[]= new int[input.length];
        Arrays.fill(arr1,input.length);
        st1.push(0);
        //next samller on right
        for(int i=0;i<input.length;i++)
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