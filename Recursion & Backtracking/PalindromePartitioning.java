class Solution {
    List<List<String>> res = new ArrayList<>();
    public boolean isPalindrome(String str){
        int i = 0;
        int j = str.length() - 1;
        while(i < j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public void helper(String s,List<String> ans){
        if(s.length() == 0){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int cut = 0; cut <= s.length() - 1; cut++){
            String cutted = s.substring(0,cut + 1);
            if(isPalindrome(cutted)){
                ans.add(cutted);
                String rem = s.substring(cut + 1);
                helper(rem,ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<String> dup= new ArrayList<>();
        helper(s,dup);
        return res;
    }
}
