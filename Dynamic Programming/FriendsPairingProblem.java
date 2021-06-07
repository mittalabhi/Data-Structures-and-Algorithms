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
                    Solution ob = new Solution();
                    System.out.println(ob.countFriendsPairings(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{       long M=1000000007;

    public long countFriendsPairings(int n) 
    { 
       //code here
       long dp[]=new long[n+1];
       return countFriendsPairingsHelperDP(n,dp);
    }
    public long countFriendsPairingsHelperDP(int n,long[] dp){
        if(n==1||n==2)
        {
            return dp[n]=n;
            //return n;
        }
        if(n<0)
        return 0;
        
        if(dp[n]!=0)
        {
            return dp[n];
        }
        long f=countFriendsPairingsHelperDP(n-1,dp);
        long s=(n-1)*countFriendsPairingsHelperDP(n-2,dp);
        return dp[n]=(f+s)%M;
    }
}    
 