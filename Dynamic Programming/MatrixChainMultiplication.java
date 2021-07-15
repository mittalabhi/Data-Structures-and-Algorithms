// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int dp[][]= new int[N][N];
        for(int d[]:dp)Arrays.fill(d,-1);
        return matrixMultiplicationDP(N,arr,0,N-1,dp);
    }
    static int matrixMultiplicationDP(int N,int arr[],int si,int ei,int dp[][])
    {
        if(ei - si == 1)
        {
            return 0;
        }
        if(dp[si][ei] != -1)
        {
            return dp[si][ei];
        }
        
        int min = (int)1e9;
        for(int cut=si+1;cut<ei;cut++)
        {
            int ans1 = matrixMultiplicationDP(N,arr,si,cut,dp);
            int ans2 = matrixMultiplicationDP(N,arr,cut,ei,dp);
            min = Math.min(min,ans1 + ans2 + arr[si]*arr[cut]*arr[ei]);
        }
        dp[si][ei] = min;
        return min;
    }
}