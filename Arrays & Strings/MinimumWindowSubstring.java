class Solution {
    public String minWindow(String s, String t) {
        int ei = 0;
        int si = 0;
        int fsi = 0;
        int fei = 0;
        int len = 0;
        int requirements = t.length();
        int map[] = new int[128];
        for(int i = 0;i < t.length(); i++){
            map[t.charAt(i)]++;
        }
        int maxLen = Integer.MAX_VALUE;
        while(ei < s.length()){
            if(map[s.charAt(ei++)]-- > 0)requirements--;

            while(requirements == 0){
                len = ei - si;
                if(len < maxLen){
                    maxLen = len;
                    fsi = si;
                    fei = ei;
                }
                if(map[s.charAt(si++)]++ == 0) requirements++;
            }
        }
        return s.substring(fsi,fei);
    }
}
