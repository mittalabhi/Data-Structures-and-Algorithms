/*package whatever //do not write package name here */

import java.io.*;

class GFG {
	public static void main (String[] args) {
	    int arr[] = {15, 27, 14, 38, 63, 55, 46, 65, 85};
	    int dp [] = new int[arr.length];
	    dp[0] = 1;
for(int i = 0;i < dp.length;i++) dp[i] =1;
	    int max = 1;
	    for(int i = 1;i < arr.length;i++){
	        for(int j = 0;j < i;j++){
	            if (arr[i] < arr[j])
	            {
	                dp[i] = Math.max(dp[i],dp[j] + 1);
	                if(dp[i] > max) max = dp[i];
	            }
	    }
	   // System.out.println(max);
	}
		    System.out.println(max);

}
}