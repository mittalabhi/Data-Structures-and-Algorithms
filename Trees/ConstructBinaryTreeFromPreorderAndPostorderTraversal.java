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
    int idx = 0;
    HashMap<Integer,Integer> hm;
    
    public TreeNode construct(int[] pre, int[] post,int start, int end){
        if(start > end) return null;
        TreeNode root = new TreeNode(pre[idx++]);
        if(start == end) return root;
        int mid = hm.get(pre[idx]);
        root.left = construct(pre,post,start,mid);
        root.right = construct(pre,post,mid + 1,end - 1);
        return root;
    }
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        hm = new HashMap<>();
        for(int i = 0;i < post.length;i++){
            hm.put(post[i],i);
        }
        return construct(pre,post,0,post.length - 1);
        
    }
}