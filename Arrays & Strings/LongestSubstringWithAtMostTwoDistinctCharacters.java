public class Solution {
    /**
     * @param s: a string
     * @return: the length of the longest substring T that contains at most 2 distinct characters
     */
   public int lengthOfLongestSubstringTwoDistinct(String s) {
        // Write your code here
        int si = 0;
        int ei = 0;
        int maxLen = 0;
        int len = s.length();
        int uc = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        boolean visited[] = new boolean[128];
        while(ei < len){
            char ch = s.charAt(ei++);
            if(!hm.containsKey(ch)){
                uc++;
                hm.put(ch,1);
            }
            else{
                hm.put(ch,hm.get(ch) + 1);
            }
            if(uc > 2){
              while(uc != 2){
                    char ch2 = s.charAt(si);
                    hm.put(ch2,hm.get(ch2) - 1);
                    si++;
                    if(hm.get(ch2) == 0){
                        uc--;
                        hm.remove(ch2);
                    }
                }
            }
            maxLen = Math.max(maxLen,ei - si);

        }
        return maxLen;
    }

}