// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
    public int helperMem(int[] arr,int[] dp,int idx){
        if(idx == 0) return dp[idx] = arr[idx];
        if(dp[idx] != arr[idx]) return dp[idx];
        int max = arr[idx];
        for(int i = 0;i < idx;i++){
            if(arr[idx] > arr[i]){
                max = Math.max(max,helperMem(arr,dp,i) + arr[idx]);
            }
        }
        return dp[idx] = max;
    }
	public int maxSumIS(int arr[], int n)  
	{  
	    
	    int dp[] = new int[n];
	    dp[0] = arr[0];
	    int max = arr[0];
	    for(int i = 0; i < dp.length;i++)
	    {
	        dp[i] = arr[i];
	    }
	    //MEMOIZATION
	    for(int i = 1;i < arr.length;i++){
	        int ans = helperMem(arr,dp,i);
	        if(ans > max) max = ans;
	    }
	    return max;
	    /* Tabulation
	    for(int i = 1;i < arr.length;i++){
	        for(int j = 0;j < i;j++){
	            if(arr[i] > arr[j]){
	                dp[i] = Math.max(dp[i],dp[j] + arr[i]);
	                if(dp[i] > max) max = dp[i];
	            }
	        }
	    }
	    return max;
	    */
	}  
}