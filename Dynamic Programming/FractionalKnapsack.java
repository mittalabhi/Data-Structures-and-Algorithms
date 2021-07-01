// { Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    class ThreeSome{
        int wt;
        int val;
        double fraction;
        
        ThreeSome(int wt,int val,double fraction){
            this.wt = wt;
            this.val = val;
            this.fraction = fraction;
        }
    }
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        ThreeSome num[] = new ThreeSome[n];
        int i = 0;
        
        for(Item ele :arr){
            double val = (double)ele.value / (double)ele.weight;
            ThreeSome obj = new ThreeSome(ele.weight,ele.value,val);
            num[i++] = obj;
        }
        Arrays.sort(num, (a, b) -> Double.compare(b.fraction, a.fraction));
        double ans = 0.0;
        for(i = 0;i < num.length; i++){
            ThreeSome obj = num[i];
            int wt = obj.wt;
            int val = obj.val;
            double frac = obj.fraction;
           // System.out.println(wt+" "+ val+ " " + frac);
            if(W - wt > 0.0){
                ans += val;
                //System.out.print("Mein ghusa loop mei");
                W -= wt;
            }
            else{
                break;
            }
        }
        if(i < num.length){
            int rem = W;
            ThreeSome obj = num[i];
            ans += (double)rem * obj.fraction;
        }
        return ans;

    }
}
