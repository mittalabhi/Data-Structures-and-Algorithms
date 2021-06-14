class Solution {
    public List<String> res = new ArrayList<>();
    public void wordBreakHelper(String s,HashSet<String> hs,String psf){
        if(s.length() == 0){
            psf = psf.trim();
            res.add(psf);
            return;
        }
        String check = "";
        for(int i = 0;i < s.length(); i++){
            check += s.charAt(i);
            if(hs.contains(check)){
                String rem = s.substring(i + 1);
                wordBreakHelper(rem,hs,psf + check +" ");
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>();
        for(int i = 0;i < wordDict.size(); i++){
            hs.add(wordDict.get(i));
        }
        wordBreakHelper(s,hs,"");
        return res;

    }
}