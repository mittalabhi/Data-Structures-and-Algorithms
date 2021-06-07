class Solution {
    public boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()];
        for(int []d:dp)Arrays.fill(d,-1);
        int m = s.length();
        String ans = removeStar(p);
        if(isMatchHelper(s,ans,m-1,ans.length() - 1,dp) == 1){
            return true;
        }
        return false;
    }
    public int isMatchHelper(String s,String p,int m,int n,int dp[][]){
        if(m == -1 || n == -1){
            if(m == -1 && n == -1){
                return 1;
            }
            else if(m == -1 && n == 0 && p.charAt(n) == '*'){
                return 1;
            }
            return 0;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        if(s.charAt(m) == p.charAt(n) || p.charAt(n) == '?'){
            dp[m][n] = isMatchHelper(s,p,m-1,n-1,dp);
        }
        else if(p.charAt(n) == '*'){
            int a1 =  isMatchHelper(s,p,m-1,n,dp);
            int a2 =  isMatchHelper(s,p,m,n-1,dp);
            if(a1 == 1 || a2 == 1){
                dp[m][n] = 1;
            }
            else{
                dp[m][n] = 0;
            } 
        }
        else{
            dp[m][n] = 0;
        }
        return dp[m][n];
    }

    public static String removeStar(String str){
        if(str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();

        sb.append(str.charAt(0));
        int i = 1;
        while(i < str.length()){
            while(i < str.length() && str.charAt(i - 1) == '*'&& str.charAt(i) == '*') i++;

            if(i < str.length()) sb.append(str.charAt(i));
            i++;
        }

        return sb.toString();
    }
}
