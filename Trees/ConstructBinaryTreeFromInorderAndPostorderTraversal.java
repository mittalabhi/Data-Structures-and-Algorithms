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
    int idx;

    public TreeNode construct(int[] postorder,int[] inorder,int start,int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(postorder[idx]);
        int mid = hm.get(postorder[idx]);
        idx--;
        if(start == end){
            root.left = null;
            root.right = null;
            return root;
        } 
        root.right = construct(postorder,inorder,mid + 1,end);
        root.left = construct(postorder,inorder,start,mid - 1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;
        hm = new HashMap<>();
        
        for(int i = 0;i < inorder.length;i++){
            hm.put(inorder[i],i);
        }
        return construct(postorder,inorder,0,inorder.length - 1);

    }
}