// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}



// } Driver Code Ends





class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here
         int dp[][] = new int[n+1][W+1];
         for(int d[] : dp)Arrays.fill(d,-1);
         return knapSackHelper(W,wt,val,n - 1,dp);
    }
    public static int knapSackHelper(int tar,int wt[],int val[],int n,int dp[][]){
        if(n < 0 || tar <= 0){
            return 0;
        }
        if(dp[n][tar] != -1){
            return dp[n][tar];
        }

        int max = 0;
        if(tar - wt[n] >= 0){
            max = knapSackHelper(tar - wt[n],wt,val,n-1,dp) + val[n];
        }
        max = Math.max(max,knapSackHelper(tar,wt,val,n-1,dp));
        return dp[n][tar] = max;
    }
}


