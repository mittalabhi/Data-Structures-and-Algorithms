public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
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
            if(uc > k){
              while(uc != k){
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