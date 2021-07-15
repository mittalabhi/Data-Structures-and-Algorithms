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
    HashMap<Integer,Integer> hm;
    int idx = 0;
    public TreeNode construct(int[] preorder,int[] inorder,int start,int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(preorder[idx++]);
        int mid = hm.get(root.val);
        root.left = construct(preorder,inorder,start,mid - 1);
        root.right = construct(preorder,inorder,mid + 1,end);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hm = new HashMap<>();
        
        for(int i = 0;i < inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return construct(preorder,inorder,0,inorder.length - 1);
    }
}