class Solution {
    public int[] asteroidCollision(int[] arr) {
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<arr.length;i++)
        {
            if(st.size()==0 || arr[i]>0)
            {
                st.push(arr[i]);
            }
            else
            {
                while(true)
                {
                    if(st.peek()<0)
                    {
                        st.push(arr[i]);
                        break;
                    }
                    else if(st.peek()==-(arr[i]))
                    {
                        st.pop();
                        break;
                    }
                    else if(st.peek()>-(arr[i]))
                    {
                        break;
                    }
                    else
                    {
                        st.pop();
                        if(st.size()==0)
                        {
                            st.push(arr[i]);
                            break;
                        }
                    }
                }
                
            }
        }
        int array[]=new int[st.size()];
        
        for(int i=array.length-1;i>=0;i--)
        {
            array[i]=st.pop();
        }
    return array;
        
        
    }
}