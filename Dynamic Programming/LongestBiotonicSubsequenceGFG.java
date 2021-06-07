//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        int ans = 0;
        for(int i =0;i < M.length; i++){
            int dp[][] = new int[n][m];
            ans = Math.max(ans,maxGoldHelperDP(M,i,0,n,m,dp));
        }
        return ans;

    }
    public static int maxGoldHelper(int M[][],int sr,int sc,int n,int m){
        if(sr < 0 || sc < 0||  sr > n - 1 || sc > m - 1){
            return 0;
        }
        if(sc == m - 1){
            return M[sr][sc];
        }
        int a = maxGoldHelper(M,sr,sc+1,n,m);
        int b = maxGoldHelper(M,sr+1,sc+1,n,m);
        int c = maxGoldHelper(M,sr-1,sc+1,n,m);
        int max = Math.max(a,Math.max(b,c));
        int ans = max + M[sr][sc];
        return ans;

    }
    public static int maxGoldHelperDP(int M[][],int sr,int sc,int n,int m,int dp[][]){
        if(sr < 0  ||sc < 0 || sr > n - 1||  sc > m - 1){
            //dp[sr][sc] = 0;
            return 0;
        }
        if(sc == m - 1){
            dp[sr][sc] = M[sr][sc];
            return M[sr][sc];
        }
        if(dp[sr][sc] != 0){
            return dp[sr][sc];
        }
        int a = maxGoldHelperDP(M,sr,sc+1,n,m,dp);
        int b = maxGoldHelperDP(M,sr+1,sc+1,n,m,dp);
        int c = maxGoldHelperDP(M,sr-1,sc+1,n,m,dp);
        int max = Math.max(a,Math.max(b,c));
        int ans = max + M[sr][sc];
        dp[sr][sc] = ans;
        return ans;

    }
}