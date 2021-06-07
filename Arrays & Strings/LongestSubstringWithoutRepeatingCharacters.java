class Solution {
    public int lengthOfLongestSubstring(String s) {
        int si = 0;
        int ei = 0;
        int maxLen = 0;
        int map[] = new int[128];
        int n = s.length();
        while(ei < n){
            char ch = s.charAt(ei);
            if(map[s.charAt(ei++)]++ == 0){

            }
            else{
                while(s.charAt(si) != ch){
                    map[s.charAt(si++)]--;
                }
                if(s.charAt(si) == ch){
                    map[s.charAt(si)]--;
                    si++;
                }

                //si++;
            }

            maxLen = Math.max(maxLen,ei - si);
        }
        return maxLen;
    }
}
