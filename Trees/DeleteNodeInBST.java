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
    public TreeNode minNode(TreeNode root)
    {
        TreeNode curr = root;
        while(curr.left != null)
        {
            return minNode(curr.left);
        }
        return  curr;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root == null)
            return null;
      
         if(root.val > key)
        {
            root.left = deleteNode(root.left,key);
        }
        else if(root.val < key)
        {
            root.right = deleteNode(root.right,key);
        }
        else
        {
            if(root.left == null && root.right == null)
            {
                return null;
            }
            else if(root.left == null || root.right == null)
            {
                TreeNode temp = root.left == null ? root.right : root.left;
                
                return temp;
            }
            else
            {
               TreeNode temp = minNode(root.right);
                int i = temp.val;
                temp.val = root.val;
                root.val = i;
                root.right = deleteNode(root.right,temp.val);
            }
        }
        return root;
        
    }
}