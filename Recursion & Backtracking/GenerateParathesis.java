class Solution {
    List<String> ans = new ArrayList<>();
    public void generateAll(int open,int closed,String res){
        if(open == 0 &&  closed  == 0){
            String newRes = res;
            ans.add(newRes);
            return;
        }
        if(closed == open) generateAll(open - 1,closed,res + "(");
        else{
            if(open - 1 >= 0) generateAll(open - 1,closed,res + "(");
            if(closed - 1 >= 0) generateAll(open,closed - 1,res + ")");
        }

    }
    public List<String> generateParenthesis(int n) {
        generateAll(n,n,"");
        return ans;
    }
}
G