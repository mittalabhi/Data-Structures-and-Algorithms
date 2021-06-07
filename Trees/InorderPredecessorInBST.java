/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
     public TreeNode maximum(TreeNode root)
     {
         TreeNode curr = root;
         while(curr.right != null)
         {
            curr = curr.right;
         }
         return curr;
     }
     TreeNode ans =  null;
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // write your code here
        if(root == null)
        return null;
        if(root.val == p.val)
        {
            if(root.left != null)
            {
                ans = maximum(root.left);
                return ans;
            }
        }
        if(root.val > p.val)
        {
            inorderPredecessor(root.left,p);
        }
        if(root.val < p.val)
        {
            ans = root;
            inorderPredecessor(root.right,p); 

        }
        return ans;
    }
}