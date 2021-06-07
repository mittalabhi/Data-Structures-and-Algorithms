import java.util.*;
import java.lang.*;
import java.io.*;

class nextGreaterElementLeft {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
    public static long[] nextLargerElement(long[] arr, int n) { 
        // Your code here
        long array[]=new long[arr.length];
        Stack<Integer> st= new Stack<>();
        st.push(0);
        Arrays.fill(array,-1);
        for(int i=arr.length-1;i>=0;i--)
        {
            
            while(st.size()!=0&&arr[i]>arr[st.peek()])
            {
                array[st.peek()]=arr[i];
                st.pop();
                
                
            
            }
            //if(arr[i]<st.peek())
            st.push(i);
        }
        //array[arr.length-1]=-1;
        return array;
        
          } 
}