/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    TreeNode ans = null;
    public TreeNode minimum(TreeNode root){
        TreeNode curr = root;
        if(curr.left != null){
            return curr = curr.left;
        }
        return curr;
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if(root == null) return null;

        if(root.val == p.val){
            if(root.right != null){
                ans = minimum(root.right);
                return ans;
            }
        }

        if(p.val < root.val){
            ans = root;
            inorderSuccessor(root.left,p);
        }
        if(p.val > root.val){
            inorderSuccessor(root.right,p);
        }
        return ans;
    }
}