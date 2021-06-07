class Solution {
    String words[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; 
    public List<String> letterCombination(String digits,int idx){
        if(idx == -1){
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        List<String> smallAns = letterCombination(digits,idx - 1);
        List<String> finAns = new ArrayList<>();
        String comb = words[digits.charAt(idx) - '0'];
        for(int i = 0;i < comb.length(); i++){
            for(String str : smallAns){
                finAns.add((str + comb.charAt(i)));
            }
        }
        return finAns;
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
       return letterCombination(digits,digits.length() - 1);
    }
}
