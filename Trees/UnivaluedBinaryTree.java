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
    public void helper(TreeNode root,Set<Integer> hs)
    {
        if(root == null)
            return;
        if(root.left ==null && root.right == null)
        {
            return;
        }
        if(root.left != null)
        {
            hs.add(root.left.val);
            helper(root.left,hs);
        }
        if(root.right != null){
            hs.add(root.right.val);
            helper(root.right,hs);
        }
    }
    
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> hs = new HashSet<>();
        helper(root,hs);
        hs.add(root.val);
        if(hs.size() == 1)
            return true;
        else
            return false;
    }
}