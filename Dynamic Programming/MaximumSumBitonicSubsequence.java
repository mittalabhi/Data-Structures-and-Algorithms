// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Compute obj = new Compute();
            System.out.println(obj.maxSumBS(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java



class Compute {
    
    public static int maxSumBS(int arr[], int n)
    {
        int dp1[] = new int[n];
        int dp2[] = new int[n];
        for(int i = 0;i < n;i++){
            dp1[i] = arr[i];
            dp2[i] = arr[i];
        }
        
        //LIS
        for(int i = 1;i < n;i++){
            for(int j = 0;j < i;j++){
                if(arr[i] > arr[j]){
                    dp1[i] = Math.max(dp1[i],dp1[j] + arr[i]);
                }
            }
        }
        for(int i = n - 2;i >= 0;i--){
            for(int j = i + 1; j < n;j++){
                if(arr[i] > arr[j]){
                    dp2[i] = Math.max(dp2[i],dp2[j] + arr[i]);
                }
            }
        }
        int max = dp1[0] + dp2[0] - arr[0];
        
        for(int i = 1; i < n;i++){
            if(dp1[i] + dp2[i] - arr[i] > max){
                max = dp1[i] + dp2[i] - arr[i];
            }
        }
        return max;
    }
}