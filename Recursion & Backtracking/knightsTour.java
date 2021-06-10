import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class knightsTour{
    public static int dir[][] = {{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1}};
     
    public static int knightsTour(int chess[][],int sr,int sc,int steps){
        chess[sr][sc] = steps;
        
        if(steps == chess.length * chess[0].length - 1) return 1;
        
        int count = 0;
        for(int i = 0;i < dir.length; i++){
            int x = sr + dir[i][0];
            int y = sc + dir[i][1];
            if(x >= 0 && y >= 0 && x < chess.length && y < chess[0].length && chess[x][y] == -1){
                count  += knightsTour(chess,x,y,steps + 1);
            }
        }
        
       chess[sr][sc] = -1;
       return count;
    }
    public static void main(String[] args) {
      
       Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int blocked = sc.nextInt();
        int blockedArea[][] = new int[m][n];
        int chess[][] = new int[m][n];
        for(int ar[] : chess) Arrays.fill(ar,-1);
        int ans = knightsTour(chess,0,0,0);
        for(int ar[] : chess){
            for(int ele : ar){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        System.out.print(ans);
    }
}