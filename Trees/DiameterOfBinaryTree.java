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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int f = diameterOfBinaryTree(root.left);
        int s = diameterOfBinaryTree(root.right);
        int th = findHeight(root.left) + findHeight(root.right) + 2;
        int max = Math.max(th,Math.max(s,f));
        return max;
    }
    public int findHeight(TreeNode root){
        if(root == null){
            return -1;
        }
        int lh = findHeight(root.left);
        int rh = findHeight(root.right);
        int th = Math.max(lh,rh) + 1;
        return th;
    }
}