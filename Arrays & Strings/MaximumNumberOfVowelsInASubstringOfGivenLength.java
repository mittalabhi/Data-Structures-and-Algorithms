class Solution {
    public boolean isVowel(Character ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')return true;
        return false;
    }
    public int maxVowels(String s, int k) {
        int ei = 0;
        int si = 0;
        int ans = 0;
        int count = 0;
        while(ei < s.length()){
            char ch = s.charAt(ei);
            if(isVowel(ch)){
                count++;
                ei++;
            }
            else{
                ei++;
            }
            if(ei - si == k){
                ans = Math.max(ans,count);
                if(isVowel(s.charAt(si))){
                count--;
            }
             si++;

            }

        }
               return ans;
    }
}