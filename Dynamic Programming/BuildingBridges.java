import java.util.*;
class BuildingBridges{
    public static void main(String[] args){
        int arr[][] = {{8,1},{1,2},{4,3},{3,4},{5,5},{2,6},{6,7},{7,8}};
        Arrays.sort(arr,(a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0]-b[0];
        });
        int dp[] = new int[arr.length];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1;i < arr.length;i++){
            for(int j = 0;j < i;j++){
                if(arr[i][1] > arr[j][1]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    if(dp[i] > max) max = dp[i];
                }
            }
        }
        System.out.print(max);
    }
}
