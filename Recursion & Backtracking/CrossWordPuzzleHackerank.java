import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

   public static ArrayList<String> res = new ArrayList<>();
   
   public static  boolean canBePlacedH(char crossWord[][],int i,int j,String str){
              //System.out.print("i:" + i +"j:" + j);
       int len = str.length();
       if(j - 1 > 0 && crossWord[i][j - 1] == '-') return false;
       if(j + len < crossWord.length  && crossWord[i][j + len] == '-') return false;
       for(int k = 0;k < len; k++){
             if(j + k >= 10) return false;
             if(crossWord[i][j + k] == str.charAt(k)){
                 continue;
             }
             else if(crossWord[i][j + k] == '-'){
                 continue;
             }
             else{
                 return false;
             }
        }
        
        
        return true; 
   }
   public static boolean canBePlacedV(char crossWord[][],int i,int j,String str){
       int len = str.length();
       if(i - 1 > 0 && crossWord[i - 1][j] == '-') return false;
       if(i + len < crossWord.length  && crossWord[i + len][j] == '-') return false;
       for(int k = 0;k < len; k++){
             if(i + k >= 10) return false;
             if(crossWord[i + k][j] == str.charAt(k)){
                 continue;
             }
             else if(crossWord[i + k][j] == '-'){
                 continue;
             }
             else{
                 return false;
             }
        }
        
        
        return true; 
   }
   public static void placeWordH(char crossWord[][],int r,int c,String str){
       //System.out.print("PlaceH");
       for(int i = 0;i < str.length(); i++){
           char ch = str.charAt(i);
           //if(c + i < crossWord.length) 
           crossWord[r][c + i] = ch;
           
           
       }
   }
   public static void placeWordV(char crossWord[][],int r,int c,String str){
      // System.out.print("PlaceV");
       for(int i = 0;i < str.length(); i++){
           char ch = str.charAt(i);
           //if(r + i < crossWord.length)  
           crossWord[r + i][c] = ch;
       }
   }
   public static void removeStringH(char crossWord[][],int r,int c,String str){
       //System.out.print("RemoveH");
       for(int i = 0;i < str.length(); i++){
           
           if(r - 1 >= 0 && crossWord[r - 1][c + i] != '-' && crossWord[r - 1][c + i] != '+') continue;
           if(r + 1 < crossWord.length && crossWord[r + 1][c + i] != '-'&& crossWord[r + 1][c + i] != '+') continue;
           crossWord[r][c + i] = '-';
           
       }
   }
    public static void removeStringV(char crossWord[][],int r,int c,String str){
              // System.out.print("RemoveV");

       for(int i = 0;i < str.length(); i++){
           
           if(c - 1 >= 0 && crossWord[r + i][c - 1] != '-' && crossWord[r + i][c - 1] != '+') continue;
           if(c + 1 < crossWord.length && crossWord[r + i][c + 1] != '-'&& crossWord[r + i][c  +1] != '+') continue;
           crossWord[r + i][c] = '-';
           
       }
   }
   public static void makeAns(char [][] crossWord){
       for(int i = 0;i < crossWord.length; i++){
           String small = "";
           for(int j = 0;j < crossWord[0].length; j++){
               small += crossWord[i][j];
           }
           String res2 = small;
           res.add(res2);
       }
   }
    public static void crossWordSolver(char [][] crossWord,int m,int n,String[] totalWords,int idx){
        if(idx == totalWords.length){
            System.out.print(1);
            makeAns(crossWord);
            return;
        }
        String toBePlaced = totalWords[idx];

        //System.out.print(toBePlaced);
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n; j++){
                if(crossWord[i][j] == '-' || crossWord[i][j] == toBePlaced.charAt(0)){
                    boolean res1 = canBePlacedH(crossWord,i,j,toBePlaced);
                   // System.out.println(toBePlaced+"" + i + j + res1);
                    System.out.println(toBePlaced+"" + i + j + res1 +"H");
                    if(res1){
                        placeWordH(crossWord,i,j,toBePlaced);
                        
                        crossWordSolver(crossWord,m,n,totalWords,idx + 1);
                        removeStringH(crossWord,i,j,toBePlaced);
                    } 
                    boolean res2 = canBePlacedV(crossWord,i,j,toBePlaced);
                    System.out.println("V" + toBePlaced+"" + i + j + res2);
                    if(res2){
                        placeWordV(crossWord,i,j,toBePlaced);
                        crossWordSolver(crossWord,m,n,totalWords,idx + 1);
                        removeStringV(crossWord,i,j,toBePlaced);
                    }
                }
            }
        }
    }
    public static List<String> crosswordPuzzle(List<String> crossword, String words) {
        String totalWords[] = words.split(";");
        char crossWord[][] = new char[crossword.size()][crossword.get(0).length()];
        int m = crossWord.length;
        int n = crossWord[0].length;
        for(int i = 0;i < m; i++){
            for(int j = 0; j < n; j++){
                crossWord[i][j] = crossword.get(i).charAt(j);
            }
        }
        crossWordSolver(crossWord,m,n,totalWords,0);
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<String> crossword = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String crosswordItem = bufferedReader.readLine();
            crossword.add(crosswordItem);
        }

        String words = bufferedReader.readLine();

        List<String> result = Result.crosswordPuzzle(crossword, words);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}