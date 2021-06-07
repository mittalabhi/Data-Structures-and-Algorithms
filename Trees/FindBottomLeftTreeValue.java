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
        public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        int ans = 0;
        int idx = 0;
        while(que.size() != 0){
            int size = que.size();
            while(size -- > 0){
                TreeNode vtx = que.removeFirst();
                if(idx == 0) ans = vtx.val;
                idx++;
                if(vtx.left != null) que.addLast(vtx.left);
                if(vtx.right != null)que.addLast(vtx.right);
            }
            idx = 0;
        }
        return ans;
    }
    
}