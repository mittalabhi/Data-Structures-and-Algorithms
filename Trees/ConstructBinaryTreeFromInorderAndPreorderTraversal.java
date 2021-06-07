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
    public TreeNode buildTree(int[] preorder,int psi,int pei,int[] inorder,int isi,int iei){
        if(psi > pei) return null;

        TreeNode root = new TreeNode(preorder[psi]);
        int idx = 0;
        while(preorder[psi] != inorder[idx]){
            idx++;
        }
        int count = idx - isi;

        root.left = buildTree(preorder,psi + 1,psi + count, inorder,isi,idx - 1);
        root.right= buildTree(preorder,psi + count + 1,pei,inorder,idx + 1,iei);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length - 1,inorder,0,inorder.length -1);
    }
}
