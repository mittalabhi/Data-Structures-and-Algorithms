/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void dfs(TreeNode root, ArrayList<Integer> ar)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            ar.add(root.val);
            return;
        }
        if(root.left != null) dfs(root.left,ar);
        if(root.right != null) dfs(root.right,ar);
     }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> ar1 = new ArrayList<>();
        ArrayList<Integer> ar2 = new ArrayList<>();
        dfs(root1,ar1);
        dfs(root2,ar2);
        if(ar1.size() != ar2.size())
            return false;
        for(int i =0;i < ar1.size();i++)
        {
           if(ar1.get(i) != ar2.get(i))
               return false;
        }
        return true;
        
    }
}