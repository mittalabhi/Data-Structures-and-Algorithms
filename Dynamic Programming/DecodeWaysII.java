class Solution {
    public int numDecodings(String s) {
        long dp[] = new long[s.length()];
        return (int)(numDecodingsHelperDP(s,0,dp));
    }
    public int numDecodingsHelper(String s,int idx){
        int M = 1000000007;
        if(idx == s.length()){
            return 1;
        }
        char ch = s.charAt(idx);
        if(ch == '0'){
            return 0;
        }
        int ans1 = 0;
        if(ch == '*'){
            ans1 += 9*numDecodingsHelper(s,idx+1);
        }
        else{
            ans1 += numDecodingsHelper(s,idx+1);
        }
        int ans2 = 0;
        if(idx < s.length() - 1){
            char ch1 = s.charAt(idx);
            char ch2 = s.charAt(idx + 1);
            int dig = (ch1 - '0') * 10 + (ch2 - '0');
            if(ch2 == '*' && ch1 == '1'){
                ans2 += 9*numDecodingsHelper(s,idx+2);
            }
            else if(ch2 == '*' && ch1 == '2'){
                ans2 += 6*numDecodingsHelper(s,idx+2);
            }
            else if(ch2 == '*' && ch1 == '*'){
                ans2 += 15*numDecodingsHelper(s,idx+2);
            }
            else if(ch1 == '*'){
                if((ch2 - '0') <= 6){
                    ans2 += 2 * numDecodingsHelper(s,idx+2);
                }
                else{
                    ans2 += 1 * numDecodingsHelper(s,idx+2);
                }
            }
            else if(dig <= 26){
                ans2 += numDecodingsHelper(s,idx+2);
            }
        }
        int ans =  ans1 +  ans2;
        return ans % M;
    }
    public long numDecodingsHelperDP(String s,int idx,long dp[]){
        long M = 1000000007;
        if(idx == s.length()){
            return 1;
        }
        char ch = s.charAt(idx);
        if(ch == '0'){
            return 0;
        }
        if(dp[idx] != 0){
            return dp[idx];
        }
        long ans1 = 0;
        if(ch == '*'){
            ans1 += 9*numDecodingsHelperDP(s,idx+1,dp);
        }
        else{
            ans1 += numDecodingsHelperDP(s,idx+1,dp);
        }
        long ans2 = 0;
        if(idx < s.length() - 1){
            char ch1 = s.charAt(idx);
            char ch2 = s.charAt(idx + 1);
            int dig = (ch1 - '0') * 10 + (ch2 - '0');
            if(ch2 == '*' && ch1 == '1'){
                ans2 += 9*numDecodingsHelperDP(s,idx+2,dp);
            }
            else if(ch2 == '*' && ch1 == '2'){
                ans2 += 6*numDecodingsHelperDP(s,idx+2,dp);
            }
            else if(ch2 == '*' && ch1 >= '3'){
                //nocall
            }
            else if(ch2 == '*' && ch1 == '*'){
                ans2 += 15*numDecodingsHelperDP(s,idx+2,dp);
            }
            else if(ch1 == '*'){
                if((ch2 - '0') <= 6){
                    ans2 += 2 * numDecodingsHelperDP(s,idx+2,dp);
                }
                else{
                    ans2 += 1 * numDecodingsHelperDP(s,idx+2,dp);
                }
            }
            else if(dig <= 26){
                ans2 += numDecodingsHelperDP(s,idx+2,dp);
            }
        }
        return dp[idx] = (ans1 + ans2) % M;
    }
}