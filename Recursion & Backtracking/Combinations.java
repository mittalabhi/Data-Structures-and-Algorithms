class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int n,int k,int idx,List<Integer> arr)
    {
        if(arr.size() == k){
            res.add(new ArrayList<>(arr));
            return;
        }
        
        if(idx > n) return;
        arr.add(idx);
        helper(n,k,idx + 1,arr);
        arr.remove(arr.size() - 1);
        helper(n,k,idx + 1,arr);
    }
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        helper(n,k,1,arr);
        return res;
    }
}